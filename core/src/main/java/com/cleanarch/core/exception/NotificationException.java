package com.cleanarch.core.exception;

public class NotificationException extends RuntimeException {
    private final String code;

    public NotificationException(String message,
                                 String code) {
        super(message);
        this.code = code;
    }
}
