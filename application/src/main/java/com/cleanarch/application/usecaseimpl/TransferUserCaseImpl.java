package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TransferGateway;
import com.cleanarch.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUserCaseImpl implements TransferUseCase {
    private TransferGateway transferGateway;

    public TransferUserCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber,
                            String toTaxNumber,
                            BigDecimal value) {
        return null;
    }
}
