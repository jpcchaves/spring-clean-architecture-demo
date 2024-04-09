package com.cleanarch.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Invalid tax number", "ON-0001"),
    TR0001("The operation could not be completed due to insufficient authorization", "TR-0001"),
    TR0002("Insufficient balance", "TR-0002"),
    TRP0001("Invalid pin", "TRP-0001");


    private final String message;
    private final String code;

    ErrorCodeEnum(String message,
                  String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
