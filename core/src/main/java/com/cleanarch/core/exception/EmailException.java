package com.cleanarch.core.exception;

public class EmailException extends RuntimeException {
    private final String code;

    public EmailException(String message,
                          String code) {
        super(message);
        this.code = code;
    }
}
