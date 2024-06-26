package com.cleanarch.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Invalid tax number", "ON-0001"),
    ON0002("Tax number not available", "ON-0002"),
    ON0003("Email not available", "ON-0003"),
    ON0004("Something went wrong creating the user", "ON-0004"),
    TR0001("The operation could not be completed due to insufficient authorization", "TR-0001"),
    TR0002("Insufficient balance", "TR-0002"),
    TR0003("An error occurred when doing a transfer", "TR-0003"),
    TR0004("The transaction was not approved", "TR-0004"),
    TR0005("An error occurred when creating the transaction", "TR-0005"),
    TRP0001("Invalid pin", "TRP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    AT0001("Failed to authenticate", "AU-0001"),
    PIN0001("Blocked transaction pin", "PIN-0001"),
    PIN0002("Invalid transaction pin, %d attempt(s) left", "PIN-0002");

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

    public static String getPin0002Message(Integer attempt) {
        return String.format(PIN0002.message, attempt);
    }
}
