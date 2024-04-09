package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
