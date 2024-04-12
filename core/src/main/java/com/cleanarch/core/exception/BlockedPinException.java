package com.cleanarch.core.exception;

public class BlockedPinException extends RuntimeException {
    private final String code;

    public BlockedPinException(String message,
                               String code) {
        super(message);
        this.code = code;
    }
}
