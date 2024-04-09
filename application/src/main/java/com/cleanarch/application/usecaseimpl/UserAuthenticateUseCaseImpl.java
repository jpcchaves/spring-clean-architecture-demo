package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.UserAuthenticateGateway;
import com.cleanarch.core.exception.AuthenticationException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username,
                                String password) {
        if(!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticationException(ErrorCodeEnum.AT0001.getCode(), ErrorCodeEnum.AT0001.getMessage());
        }

        return true;
    }
}
