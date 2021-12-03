package br.inatel.projeto.DAO;

import br.inatel.projeto.Classes.Alugado;
import br.inatel.projeto.Classes.Cliente;
import java.sql.SQLException;

public class AlugadoDAO extends ConnectionDAO{
    boolean sucesso = false;
    JogoDAO atjogo = new JogoDAO();

    //DAO -DATA ACCESS OBJECT
    public boolean inserirAlugado(Alugado alugado)  {
        connectToDB();
        String sql = "INSERT INTO alugado (data_alugado, data_devolucao, cliente_id, jogo_id) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, alugado.getData_alugado());
            pst.setString(2, alugado.getData_devolucao());
            pst.setInt(3, alugado.getCliente_id());
            pst.setInt(4, alugado.getJogo_id());
            atjogo.atualizarJogo(alugado.getJogo_id(),true);
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

    public boolean atualizarAlugado(int id, Alugado alugado) {
        connectToDB();
        String sql = "UPDATE cliente SET data_alugado, data_devolucao =?, cliente_id =?, jogo_id=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, alugado.getData_alugado());
            pst.setString(2, alugado.getData_devolucao());
            pst.setInt(3, alugado.getCliente_id());
            pst.setInt(4, alugado.getJogo_id());
            pst.setInt(5, id);
            pst.execute();
            atjogo.atualizarJogo(id, false);
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

    public boolean deletarAlugado(int id) {
        connectToDB();
        String sql = "DELETE FROM alugado where id=?";

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
}
