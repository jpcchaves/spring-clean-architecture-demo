package com.cleanarch.infrastructure.mapper;

import com.cleanarch.core.domain.TransactionPin;
import com.cleanarch.infrastructure.persistence.entity.TransactionPinEntity;
import com.cleanarch.infrastructure.utils.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
  private final MapperUtils mapperUtils;

  public TransactionPinMapper(MapperUtils mapperUtils) {
    this.mapperUtils = mapperUtils;
  }

  public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
    return new TransactionPinEntity(transactionPin.getPin(), transactionPin.getAttempt(), transactionPin.getBlocked(), transactionPin.getCreatedAt(), transactionPin.getUpdatedAt());
  }

  public TransactionPin toCoreTransactionPin(TransactionPinEntity transactionPinEntity) {
    return mapperUtils.parseObject(transactionPinEntity, TransactionPin.class);
  }

}
