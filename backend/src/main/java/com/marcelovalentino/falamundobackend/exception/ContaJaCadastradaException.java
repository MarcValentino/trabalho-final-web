package com.marcelovalentino.falamundobackend.exception;

public class ContaJaCadastradaException extends RuntimeException {
    public ContaJaCadastradaException() {
        super("Conta já cadastrada.");
    }
    public ContaJaCadastradaException(String message) {
        super(message);
    }
}

