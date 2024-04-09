package com.cleanarch.core.exception;

public class InternalServerError extends RuntimeException {
    private String code;

    public InternalServerError(String message,
                               String code) {
        super(message);
        this.code = code;
    }
}
