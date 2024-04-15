package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TransferGateway;
import com.cleanarch.core.domain.Transaction;
import com.cleanarch.core.exception.InternalServerError;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.TransferUseCase;

public class TransferUseCaseImpl implements TransferUseCase {
    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(Transaction transaction) {
        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());

        if(!transferGateway.tranfer(transaction)) {
            throw new InternalServerError(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
