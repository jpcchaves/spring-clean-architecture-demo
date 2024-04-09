package com.cleanarch.usecase;

import com.cleanarch.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
