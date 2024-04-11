package com.cleanarch.application.gateway;

import com.cleanarch.core.domain.User;
import com.cleanarch.core.domain.Wallet;

public interface CreateUserGateway {
    boolean create(User user, Wallet wallet);
}
