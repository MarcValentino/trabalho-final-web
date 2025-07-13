package com.marcelovalentino.falamundobackend.exception;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException() {
        super("Usuário ou senha inválidos");
    }
    public CredenciaisInvalidasException(String message) {
        super(message);
    }
}

