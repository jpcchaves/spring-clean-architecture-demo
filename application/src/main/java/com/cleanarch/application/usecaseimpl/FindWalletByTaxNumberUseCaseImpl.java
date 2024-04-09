package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.FindWalletByTaxNumberGateway;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.core.exception.NotFoundException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.FindWalletByTaxNumberUseCase;

import java.util.Objects;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;
    @Override
    public Wallet findByTaxNumber(String taxNumber) {
        Wallet wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if(Objects.isNull(wallet)) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getCode(), ErrorCodeEnum.WA0001.getMessage());
        }

        return wallet;
    }
}
