package com.cleanarch.usecase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password);
}
