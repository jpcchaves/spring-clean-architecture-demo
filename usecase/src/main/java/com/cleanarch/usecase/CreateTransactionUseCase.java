package com.cleanarch.usecase;

import com.cleanarch.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
