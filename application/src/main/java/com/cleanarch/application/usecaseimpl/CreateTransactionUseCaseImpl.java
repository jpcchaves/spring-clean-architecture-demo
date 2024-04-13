package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.CreateTransactionGateway;
import com.cleanarch.core.domain.Transaction;
import com.cleanarch.core.exception.InvalidTransactionException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.CreateTransactionUseCase;

import java.util.Objects;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) {
        Transaction createdTransaction = createTransactionGateway.transaction(transaction);

        if(Objects.isNull(createdTransaction)) {
            throw new InvalidTransactionException(ErrorCodeEnum.TR0005.getMessage(), ErrorCodeEnum.TR0005.getMessage());
        }

        return createdTransaction;
    }
}
