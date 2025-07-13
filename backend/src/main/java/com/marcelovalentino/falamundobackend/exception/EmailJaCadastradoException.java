package com.marcelovalentino.falamundobackend.exception;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException() {
        super("Email já cadastrado.");
    }
    public EmailJaCadastradoException(String message) {
        super(message);
    }
}

