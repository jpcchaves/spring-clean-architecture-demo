package com.cleanarch.usecase;

import com.cleanarch.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
