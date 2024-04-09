package com.cleanarch.usecase;

import com.cleanarch.core.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction);
}
