package br.inatel.projeto.Classes;

public class Jogo {

    private int id;
    private String nome;
    private String desenvolvedor;
    private String dataLancamento;
    private String plataforma;
    private float preco;
    private boolean alugado;

    public Jogo(String nome, String desenvolvedor, String dataLancamento, String plataforma, float preco) {
        this.nome = nome;
        this.desenvolvedor = desenvolvedor;
        this.dataLancamento = dataLancamento;
        this.plataforma = plataforma;
        this.preco = preco;
        this.alugado = false;
    }

    public Jogo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}
