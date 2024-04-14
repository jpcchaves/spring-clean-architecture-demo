package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.EmailAvailableGateway;
import com.cleanarch.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public boolean isAvailable(String email) {
        return true;
    }
}
