package br.edu.infnet.dominio;

import br.edu.infnet.exceptions.NomeInvalido;

public class Pessoa {

    private String nome;
    private String sobreNome;
    private String ultimoNome;
    private String cargo;

    public Pessoa() {
        this.nome = "Fulano";
        setCargo("Indefinido");
    }


    public Pessoa(String cargo) {
        this();
        setCargo(cargo);
    }


    public void consultarSituacao() {
        System.out.println("-------------------------------------------");
        System.out.println("CARGO: " + getCargo());
        System.out.println("NOME: " + getNome());
        System.out.println("SOBRENOME: " + getSobreNome());
        System.out.println("ULTIMO NOME: " + getUltimoNome());
    };

    @Override
    public String toString() {
        return "Nome" + getNome() + ", cargo:" + getCargo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeInvalido {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
