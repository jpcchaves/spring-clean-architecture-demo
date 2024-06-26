package com.cleanarch.usecase;

import com.cleanarch.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consultBalance(Wallet wallet);
}
