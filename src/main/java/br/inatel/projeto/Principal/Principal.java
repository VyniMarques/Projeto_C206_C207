package br.inatel.projeto.Principal;

import br.inatel.projeto.Classes.Alugado;
import br.inatel.projeto.Classes.Cliente;
import br.inatel.projeto.Classes.Jogo;
import br.inatel.projeto.DAO.AlugadoDAO;
import br.inatel.projeto.DAO.ClienteDAO;
import br.inatel.projeto.DAO.JogoDAO;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner input =  new Scanner (System.in);

        ArrayList<Jogo> auxJogos = new ArrayList<>();
        ArrayList<Cliente> auxCliente = new ArrayList<>();
        JogoDAO jogos = new JogoDAO();
        ClienteDAO clientes = new ClienteDAO();
        AlugadoDAO alugados = new AlugadoDAO();
        int id;
        boolean flag = true;
        while (flag) {
            System.out.println("===============================================");
            System.out.println("1 - Inseir um novo jogo");
            System.out.println("2 - Inserir um novo cliente");
            System.out.println("3 - Alugando um jogo");
            System.out.println("4 - Mostrar todos os jogos");
            System.out.println("5 - Mostrar jogos disponiveis");
            System.out.println("6 - Mostrar jogos alugados");
            System.out.println("7 - Buscar jogo por nome");
            System.out.println("8 - Cancelar um pedido/devolver");
            System.out.println("9 - Deletar um jogo");
            System.out.println("10 - Mostrar todos os clientes");
            System.out.println("11 - Deletar um cliente");
            System.out.println("12 - Encerrar");
            System.out.println("===============================================");
            int op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome do jogo: ");
                    String nome = input.nextLine();
                    System.out.println("Digite o desenvolvedor do jogo: ");
                    String desenvolvedor = input.nextLine();
                    System.out.println("Digite a data de lançamento do jogo: ");
                    String dataLancamento = input.nextLine();
                    System.out.println("Digite a plataforma do jogo: ");
                    String plataforma = input.nextLine();
                    System.out.println("Digite o preço do jogo: ");
                    float preco = input.nextFloat();
                    Jogo novoJogo = new Jogo(nome,desenvolvedor,dataLancamento,plataforma,preco);
                    jogos.inserirJogo(novoJogo);
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    nome = input.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    int idade = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o endereço do cliente: ");
                    String endereco = input.nextLine();
                    System.out.println("Digite o telefone do cliente: ");
                    String telefone = input.nextLine();
                    System.out.println("Digite o email do cliente: ");
                    String email = input.nextLine();
                    Cliente novoCliente = new Cliente(nome,idade,endereco,telefone,email);
                    clientes.inserirCliente(novoCliente);
                    break;
                case 3:
                    boolean flag2 = true;
                    System.out.println("Digite a data em que foi alugado: ");
                    String data_alugado = input.nextLine();
                    System.out.println("Digite a data de devolucao: ");
                    String data_devolucao = input.nextLine();
                    System.out.println("Digite o id do cliente: ");
                    int cliente_id = input.nextInt();
                    System.out.println("Digite o id do jogo: ");
                    int jogo_id = input.nextInt();
                    auxJogos = jogos.buscaJogos(3);
                    for(int i = 0; i<auxJogos.size();i++)
                        if(auxJogos.get(i).getId() == jogo_id) {
                            System.out.println("Este jogo ja foi alugado!");
                            flag2 = false;
                        }
                    if (flag2 == true) {
                        Alugado alugadoAUX = new Alugado(data_alugado, data_devolucao, cliente_id, jogo_id);
                        alugados.inserirAlugado(alugadoAUX);
                    }
                    break;
                case 4:
                    auxJogos = jogos.buscaJogos(1);
                    for(int i = 0; i < auxJogos.size();i++){
                        System.out.println(" ");
                        System.out.println("Jogo " + i);
                        System.out.println("Nome do jogo: ");
                        System.out.println(auxJogos.get(i).getNome());
                        System.out.println("Desenvolvedor do jogo: ");
                        System.out.println(auxJogos.get(i).getDesenvolvedor());
                        System.out.println("Data de lançamento do jogo:");
                        System.out.println(auxJogos.get(i).getDataLancamento());
                        System.out.println("Plataforma do jogo: ");
                        System.out.println(auxJogos.get(i).getPlataforma());
                        System.out.println("Preco do jogo: ");
                        System.out.println(auxJogos.get(i).getPreco());
                    }
                    break;
                case 5:
                    System.out.println(" ");
                    auxJogos = jogos.buscaJogos(2);
                    for(int i = 0; i < auxJogos.size();i++){
                        System.out.println(auxJogos.get(i).getNome());
                    }
                    break;
                case 6:
                    System.out.println(" ");
                    auxJogos = jogos.buscaJogos(3);
                    for(int i = 0; i < auxJogos.size();i++){
                        System.out.println(auxJogos.get(i).getNome());
                    }
                    break;
                case 7:
                    System.out.println(" ");
                    Jogo buscjogo = new Jogo();
                    nome = input.nextLine();
                    buscjogo = jogos.buscarJogoPorNome(nome);
                    System.out.println("Nome do jogo:");
                    System.out.println(buscjogo.getNome());
                    System.out.println("Desenvolvedor do jogo: ");
                    System.out.println(buscjogo.getDesenvolvedor());
                    System.out.println("Data de lançamento do jogo:");
                    System.out.println(buscjogo.getDataLancamento());
                    System.out.println("Plataforma do jogo: ");
                    System.out.println(buscjogo.getPlataforma());
                    System.out.println("Preco do jogo: ");
                    System.out.println(buscjogo.getPreco());
                    System.out.println("O jogo esta alugado: ");
                    System.out.println(buscjogo.isAlugado());
                    break;
                case 8:
                    System.out.println("Entre com o id do pedido que deseja cancelar/devolver: ");
                    id = input.nextInt();
                    alugados.deletarAlugado(id);
                    break;
                case 9:
                    System.out.println("Entre com o id do jogo que deseja deletar: ");
                    id = input.nextInt();
                    jogos.deletarJogo(id);
                    break;
                case 10:
                    auxCliente = clientes.buscaCliente();
                    for(int i = 0; i < auxCliente.size();i++){
                        System.out.println(" ");
                        System.out.println("Cliente " + i);
                        System.out.println("Nome do cliente: ");
                        System.out.println(auxCliente.get(i).getNome());
                        System.out.println("Idade do cliente: ");
                        System.out.println(auxCliente.get(i).getIdade());
                        System.out.println("Endereço do cliente:");
                        System.out.println(auxCliente.get(i).getEndereco());
                        System.out.println("Telefone do cliente: ");
                        System.out.println(auxCliente.get(i).getTelefone());
                        System.out.println("Email do cliente: ");
                        System.out.println(auxCliente.get(i).getEmail());
                    }
                    break;
                case 11:
                    System.out.println("Entre com od id do cliente que deseja deletar: ");
                    id = input.nextInt();
                    clientes.deletarCliente(id);
                    break;
                case 12:
                    flag = false;
                    break;
            }
        }
    }
}
