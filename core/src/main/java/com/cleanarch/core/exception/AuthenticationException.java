package com.cleanarch.core.exception;

public class AuthenticationException extends RuntimeException {
    private final String code;

    public AuthenticationException(String message,
                                   String code) {
        super(message);
        this.code = code;
    }
}
