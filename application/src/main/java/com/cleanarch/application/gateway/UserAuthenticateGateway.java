package com.cleanarch.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
