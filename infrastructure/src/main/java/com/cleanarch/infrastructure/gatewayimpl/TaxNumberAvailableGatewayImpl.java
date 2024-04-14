package com.cleanarch.infrastructure.gatewayimpl;

import com.cleanarch.application.gateway.TaxNumberAvailableGateway;
import org.springframework.stereotype.Service;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

  @Override
  public Boolean isAvailable(String taxNumber) {
    return true;
  }
}
