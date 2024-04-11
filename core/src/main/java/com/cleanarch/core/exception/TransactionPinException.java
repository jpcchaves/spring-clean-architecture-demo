package com.cleanarch.core.exception;

public class TransactionPinException extends RuntimeException {
    private String code;

    public TransactionPinException(String code,
                                   String message) {
        super(message);
        this.code = code;
    }
}
