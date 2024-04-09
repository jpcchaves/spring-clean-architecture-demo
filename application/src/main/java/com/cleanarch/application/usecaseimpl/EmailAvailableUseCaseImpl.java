package com.cleanarch.application.usecaseimpl;

import com.cleanarch.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    @Override
    public boolean isAvailable(String email) {
        return false;
    }
}
