package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TransferGateway;
import com.cleanarch.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber,
                            String toTaxNumber,
                            BigDecimal value,
                            String pin) {
//        TODO: implement transfer operation
        transferGateway.tranfer(null);
        return null;
    }
}
