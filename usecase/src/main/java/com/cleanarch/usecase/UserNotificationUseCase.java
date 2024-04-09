package com.cleanarch.usecase;

import com.cleanarch.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
