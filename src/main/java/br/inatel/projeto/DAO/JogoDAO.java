package br.inatel.projeto.DAO;

import br.inatel.projeto.Classes.Jogo;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogoDAO extends ConnectionDAO {
    boolean sucesso = false;

    //DAO -DATA ACCESS OBJECT
    public boolean inserirJogo(Jogo jogo) {
        connectToDB();
        String sql = "INSERT INTO jogo (nome, desenvolvedor, dataLancamento,plataforma,  preco,alugado) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogo.getNome());
            pst.setString(2, jogo.getDesenvolvedor());
            pst.setString(3, jogo.getDataLancamento());
            pst.setString(4, jogo.getPlataforma());
            pst.setFloat(5, jogo.getPreco());
            pst.setBoolean(6, jogo.isAlugado());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean atualizarJogo(int id,boolean alug) {
        connectToDB();
        String sql = "UPDATE jogo SET alugado=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setBoolean(1, alug);
            pst.setInt(2, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deletarJogo(int id) {
        connectToDB();
        String sql = "DELETE FROM jogo where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }


    public ArrayList<Jogo> buscaJogos(int fun) {
        ArrayList<Jogo> listaDejogos = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM jogo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Jogo jogoAux = new Jogo();
                jogoAux.setId(rs.getInt("id"));
                jogoAux.setNome(rs.getString("nome"));
                jogoAux.setDesenvolvedor(rs.getString("desenvolvedor"));
                jogoAux.setDataLancamento((rs.getString("dataLancamento")));
                jogoAux.setPlataforma(rs.getString("plataforma"));
                jogoAux.setPreco(rs.getFloat("preco"));
                jogoAux.setAlugado(rs.getBoolean("alugado"));

                if (fun == 1)
                    listaDejogos.add(jogoAux);
                else if (fun == 2 && jogoAux.isAlugado() == false)
                    listaDejogos.add(jogoAux);
                else if (fun == 3 && jogoAux.isAlugado() == true)
                    listaDejogos.add(jogoAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDejogos;
    }

    public Jogo buscarJogoPorNome(String nome) {

        connectToDB();
        Jogo jogoAux = null;
        String sql = "SELECT * FROM Jogo WHERE nome = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("nome");
                if (aux.isEmpty()) {
                    sucesso = false;
                } else {
                    jogoAux = new Jogo();
                    jogoAux.setNome(rs.getString("nome"));
                    jogoAux.setDesenvolvedor(rs.getString("desenvolvedor"));
                    jogoAux.setDataLancamento((rs.getString("dataLancamento")));
                    jogoAux.setPlataforma(rs.getString("plataforma"));
                    jogoAux.setPreco(rs.getFloat("preco"));
                    jogoAux.setAlugado(rs.getBoolean("plataforma"));
                }
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return jogoAux;
    }
}

