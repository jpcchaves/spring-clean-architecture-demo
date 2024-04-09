package com.cleanarch.usecase;

import com.cleanarch.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
