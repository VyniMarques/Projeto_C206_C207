package br.inatel.projeto.Classes;

public class Alugado {

    private String data_alugado;
    private String data_devolucao;
    private int cliente_id;
    private int jogo_id;

    public Alugado(String data_alugado, String data_devolucao, int cliente_id, int jogo_id) {
        this.data_alugado = data_alugado;
        this.data_devolucao = data_devolucao;
        this.cliente_id = cliente_id;
        this.jogo_id = jogo_id;
    }

    public String getData_alugado() {
        return data_alugado;
    }

    public void setData_alugado(String data_alugado) {
        this.data_alugado = data_alugado;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getJogo_id() {
        return jogo_id;
    }

    public void setJogo_id(int jogo_id) {
        this.jogo_id = jogo_id;
    }
}
