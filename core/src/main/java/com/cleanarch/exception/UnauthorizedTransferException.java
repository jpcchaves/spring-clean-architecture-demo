package com.cleanarch.exception;

public class UnauthorizedTransferException extends RuntimeException {
    private String code;

    public UnauthorizedTransferException(String message,
                                         String code) {
        super(message);
        this.code = code;
    }
}
