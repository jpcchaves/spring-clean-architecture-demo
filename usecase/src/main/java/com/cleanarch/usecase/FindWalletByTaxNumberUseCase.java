package com.cleanarch.usecase;

import com.cleanarch.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber);
}
