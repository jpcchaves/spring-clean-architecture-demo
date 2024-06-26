package com.cleanarch.core.exception;

public class InsufficientBalanceException extends RuntimeException {
    private String code;

    public InsufficientBalanceException(String message,
                                        String code) {
        super(message);
        this.code = code;
    }
}
