package com.cleanarch.usecase;

import com.cleanarch.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
