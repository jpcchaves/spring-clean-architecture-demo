package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin);
}
