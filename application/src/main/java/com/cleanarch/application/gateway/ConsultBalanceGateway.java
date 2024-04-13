package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consultBalance(Wallet wallet);
}
