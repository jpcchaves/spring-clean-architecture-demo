package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);

}
