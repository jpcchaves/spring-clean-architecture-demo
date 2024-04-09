package com.cleanarch.usecase;

import com.cleanarch.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
