package com.cleanarch.usecase;

import com.cleanarch.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
