package com.cleanarch.core.exception;

public class InvalidTransactionPinException extends RuntimeException {
    private String code;

    public InvalidTransactionPinException(String code,
                                          String message) {
        super(message);
        this.code = code;
    }
}