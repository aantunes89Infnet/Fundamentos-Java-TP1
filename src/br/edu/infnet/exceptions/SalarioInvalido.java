package br.edu.infnet.exceptions;

public class SalarioInvalido extends Exception{

    private static final long serialVersionUID = 1L;

    public SalarioInvalido(String msg) {
        super(msg);
    }
}
