package com.cleanarch.infrastructure.config;

import com.cleanarch.application.gateway.CreateUserGateway;
import com.cleanarch.application.gateway.EmailAvailableGateway;
import com.cleanarch.application.gateway.TaxNumberAvailableGateway;
import com.cleanarch.application.usecaseimpl.CreateUserUseCaseImpl;
import com.cleanarch.application.usecaseimpl.EmailAvailableUseCaseImpl;
import com.cleanarch.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import com.cleanarch.usecase.CreateUserUseCase;
import com.cleanarch.usecase.EmailAvailableUseCase;
import com.cleanarch.usecase.TaxNumberAvailableUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
  @Bean
  public TaxNumberAvailableUsecase taxNumberAvailableUsecase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
    return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
  }

  @Bean
  public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
    return new EmailAvailableUseCaseImpl(emailAvailableGateway);
  }

  @Bean
  public CreateUserUseCase createUserUseCase(TaxNumberAvailableUsecase taxNumberAvailableUsecase,
                                             EmailAvailableUseCase emailAvailableUseCase,
                                             CreateUserGateway createUserGateway) {
    return new CreateUserUseCaseImpl(taxNumberAvailableUsecase, emailAvailableUseCase, createUserGateway);
  }
}
