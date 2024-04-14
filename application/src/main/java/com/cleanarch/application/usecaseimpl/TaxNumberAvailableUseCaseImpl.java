package com.cleanarch.application.usecaseimpl;

import com.cleanarch.application.gateway.TaxNumberAvailableGateway;
import com.cleanarch.usecase.TaxNumberAvailableUsecase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUsecase {
    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

  public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
    this.taxNumberAvailableGateway = taxNumberAvailableGateway;
  }

  @Override
    public Boolean isAvailable(String taxNumber) {
        return null;
    }
}
