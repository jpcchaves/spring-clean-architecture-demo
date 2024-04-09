package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TransactionValidateGateway;
import com.cleanarch.core.domain.Transaction;
import com.cleanarch.core.exception.InvalidTransactionException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {
    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        if(!transactionValidateGateway.validate(transaction)) {
            throw new InvalidTransactionException(ErrorCodeEnum.TR0004.getCode(), ErrorCodeEnum.TR0004.getMessage());
        }

        return true;
    }
}
