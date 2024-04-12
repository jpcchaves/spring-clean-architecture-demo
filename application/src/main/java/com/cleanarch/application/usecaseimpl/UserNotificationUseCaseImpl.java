package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.UserNotificationGateway;
import com.cleanarch.core.domain.Transaction;
import com.cleanarch.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {
    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction,
                              String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
