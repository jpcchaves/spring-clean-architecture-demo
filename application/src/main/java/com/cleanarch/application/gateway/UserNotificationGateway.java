package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
