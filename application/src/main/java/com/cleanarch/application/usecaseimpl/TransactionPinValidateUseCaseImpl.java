package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TransactionPinValidateGateway;
import com.cleanarch.core.domain.TransactionPin;
import com.cleanarch.core.exception.BlockedPinException;
import com.cleanarch.core.exception.TransactionPinException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.TransactionPinValidateUseCase;
import com.cleanarch.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
   private final TransactionPinValidateGateway transactionPinValidateGateway;
   private final UpdateTransactionPinUseCase updateTransactionPinUseCase;


    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway,
                                             UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        if(transactionPin.getBlocked())  {
            throw new BlockedPinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }


        if(!transactionPinValidateGateway.validate(transactionPin)){
            transactionPin.setAttempt();

            TransactionPin updatedTransactionPin = updateTransactionPinUseCase.update(transactionPin);

            throw new TransactionPinException(ErrorCodeEnum.PIN0002.getCode(),
                    ErrorCodeEnum.getPin0002Message(updatedTransactionPin.getAttempt()));
        }

        if(transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempts();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
