package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.CreateUserGateway;
import com.cleanarch.core.domain.TransactionPin;
import com.cleanarch.core.domain.User;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.core.exception.EmailException;
import com.cleanarch.core.exception.InternalServerError;
import com.cleanarch.core.exception.TaxNumberException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;
import com.cleanarch.usecase.CreateUserUseCase;
import com.cleanarch.usecase.EmailAvailableUseCase;
import com.cleanarch.usecase.TaxNumberAvailableUsecase;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final TaxNumberAvailableUsecase taxNumberAvailableUsecase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateUserGateway createUserGateway;
    private final static Logger logger = Logger.getLogger(CreateUserUseCaseImpl.class.getName());

    public CreateUserUseCaseImpl(TaxNumberAvailableUsecase taxNumberAvailableUsecase,
                                 EmailAvailableUseCase emailAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUsecase = taxNumberAvailableUsecase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) {
      logger.info(user.getTaxNumber().getValue());
       if(!taxNumberAvailableUsecase.isAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getCode(), ErrorCodeEnum.ON0002.getMessage());
       }

       if(!emailAvailableUseCase.isAvailable(user.getEmail())) {
           throw new EmailException(ErrorCodeEnum.ON0003.getCode(), ErrorCodeEnum.ON0003.getMessage());
       }

       if(!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
           throw new InternalServerError(ErrorCodeEnum.ON0004.getCode(), ErrorCodeEnum.ON0004.getMessage());
       }
    }
}
