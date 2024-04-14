package com.cleanarch.infrastructure.mapper;

import com.cleanarch.core.domain.Wallet;
import com.cleanarch.infrastructure.dto.wallet.WalletRequestDTO;
import com.cleanarch.infrastructure.persistence.entity.WalletEntity;
import com.cleanarch.infrastructure.utils.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
  private final MapperUtils mapperUtils;

  public WalletMapper(MapperUtils mapperUtils) {
    this.mapperUtils = mapperUtils;
  }

  public WalletEntity toWalletEntity(Wallet wallet) {
    return mapperUtils.parseObject(wallet, WalletEntity.class);
  }

  public Wallet toCoreWallet(WalletRequestDTO walletRequestDTO) {
    return mapperUtils.parseObject(walletRequestDTO, Wallet.class);
  }

}
