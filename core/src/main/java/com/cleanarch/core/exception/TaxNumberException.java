package com.cleanarch.core.exception;

public class TaxNumberException extends RuntimeException {
    private final String code;

    public TaxNumberException(String message,
                              String code) {
        super(message);
        this.code = code;
    }
}
