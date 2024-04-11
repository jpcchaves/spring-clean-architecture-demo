package com.cleanarch.usecase;

import com.cleanarch.core.domain.TransactionPin;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin);
}
