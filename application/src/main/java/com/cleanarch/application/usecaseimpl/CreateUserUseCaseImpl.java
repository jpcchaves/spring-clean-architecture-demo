package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.CreateUserGateway;
import com.cleanarch.core.domain.TransactionPin;
import com.cleanarch.core.domain.User;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.core.exception.EmailException;
import com.cleanarch.core.exception.InternalServerError;
import com.cleanarch.core.exception.TaxNumberException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUsecase taxNumberAvailableUsecase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUsecase taxNumberAvailableUsecase,
                                 EmailAvailableUseCase emailAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUsecase = taxNumberAvailableUsecase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) {
       if(taxNumberAvailableUsecase.isAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getCode(), ErrorCodeEnum.ON0002.getMessage());
       }

       if(emailAvailableUseCase.isAvailable(user.getEmail())) {
           throw new EmailException(ErrorCodeEnum.ON0003.getCode(), ErrorCodeEnum.ON0003.getMessage());
       }

       if(!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
           throw new InternalServerError(ErrorCodeEnum.ON0004.getCode(), ErrorCodeEnum.ON0004.getMessage());
       }
    }
}
