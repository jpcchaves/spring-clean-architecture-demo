package com.cleanarch.core.exception;

public class InvalidTransactionException extends RuntimeException {
    private String code;

    public InvalidTransactionException(String message,
                                       String code) {
        super(message);
        this.code = code;
    }
}
