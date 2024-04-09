package com.cleanarch.usecase;

import com.cleanarch.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
