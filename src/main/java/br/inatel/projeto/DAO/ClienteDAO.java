package br.inatel.projeto.DAO;

import br.inatel.projeto.Classes.Cliente;
import br.inatel.projeto.Classes.Jogo;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends ConnectionDAO {
    boolean sucesso = false;

    //DAO -DATA ACCESS OBJECT
    public boolean inserirCliente(Cliente cliente) {
        connectToDB();
        String sql = "INSERT INTO cliente (nome, idade, endereco, telefone, email) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getIdade());
            pst.setString(3, cliente.getEndereco());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEmail());

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

    public boolean atualizarCliente(int id, Cliente cliente) {
        connectToDB();
        String sql = "UPDATE cliente SET nome =?, idade =?, endereco =?, telefone =?, email =? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getIdade());
            pst.setString(3, cliente.getEndereco());
            pst.setString(4, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setInt(5, id);
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

    public boolean deletarCliente(int id) {
        connectToDB();
        String sql = "DELETE FROM cliente where id=?";

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

    public ArrayList<Cliente> buscaCliente() {
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM cliente";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente clienteAux = new Cliente();
                clienteAux.setNome(rs.getString("nome"));
                clienteAux.setIdade(rs.getInt("idade"));
                clienteAux.setEndereco((rs.getString("endereco")));
                clienteAux.setTelefone(rs.getString("telefone"));
                clienteAux.setEmail(rs.getString("email"));
                listaDeClientes.add(clienteAux);
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
        return listaDeClientes;
    }
}