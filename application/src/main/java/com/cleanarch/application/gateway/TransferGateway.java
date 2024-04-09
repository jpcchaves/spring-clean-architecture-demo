package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Transaction;

public interface TransferGateway {
    Boolean tranfer(Transaction transaction);
}
