package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.ConsultBalanceGateway;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private final ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consultBalance(Wallet wallet) {
        return consultBalanceGateway.consultBalance(wallet);
    }
}
