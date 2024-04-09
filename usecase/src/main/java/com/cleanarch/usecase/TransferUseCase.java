package com.cleanarch.usecase;

import com.cleanarch.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
