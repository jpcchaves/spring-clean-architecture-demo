package com.cleanarch.usecase;

import com.cleanarch.core.domain.User;

public interface CreateUserUseCase {
    void create(User user, String pin);
}
