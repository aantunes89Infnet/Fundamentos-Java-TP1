package br.edu.infnet.dominio;

public class Pessoa {

    private String nome;
    private int idade;
    private String instituicao;
    private String situacao;

    public Pessoa() {
        setNome("Pessoa");
        setIdade(10);
    }

    public Pessoa(String nome, int idade) {
        this();
        setNome(nome);
        setIdade(idade);
    }

    public Pessoa(String nome, int idade, String instituicao) {
        this(nome, idade);
        setInstituicao(instituicao);
    }


    protected String consultarSituacao() {
        return getNome() + " " + getIdade() + " " + getInstituicao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
