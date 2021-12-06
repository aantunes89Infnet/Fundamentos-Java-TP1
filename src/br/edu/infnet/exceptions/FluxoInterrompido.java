package br.edu.infnet.exceptions;

public class FluxoInterrompido extends Exception{
    private static final long serialVersionUID = 1L;

    public FluxoInterrompido(String msg) {
        super(msg);
    }
}
