package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction transaction(Transaction transaction);
}
