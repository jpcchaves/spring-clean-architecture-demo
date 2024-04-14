package com.cleanarch.infrastructure.gatewayimpl;

import com.cleanarch.application.gateway.CreateUserGateway;
import com.cleanarch.core.domain.User;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.infrastructure.mapper.TransactionPinMapper;
import com.cleanarch.infrastructure.mapper.UserMapper;
import com.cleanarch.infrastructure.mapper.WalletMapper;
import com.cleanarch.infrastructure.persistence.entity.TransactionPinEntity;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;
import com.cleanarch.infrastructure.persistence.repository.TransactionPinRepository;
import com.cleanarch.infrastructure.persistence.repository.UserRepository;
import com.cleanarch.infrastructure.persistence.repository.WalletRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateUserGatewayImpl implements CreateUserGateway {
  private final UserRepository userRepository;
  private final WalletRepository walletRepository;
  private final TransactionPinRepository transactionPinRepository;
  private final TransactionPinMapper transactionPinMapper;
  private final UserMapper userMapper;
  private final WalletMapper walletMapper;

  public CreateUserGatewayImpl(UserRepository userRepository,
                               WalletRepository walletRepository,
                               TransactionPinRepository transactionPinRepository,
                               TransactionPinMapper transactionPinMapper,
                               UserMapper userMapper,
                               WalletMapper walletMapper) {
    this.userRepository = userRepository;
    this.walletRepository = walletRepository;
    this.transactionPinRepository = transactionPinRepository;
    this.transactionPinMapper = transactionPinMapper;
    this.userMapper = userMapper;
    this.walletMapper = walletMapper;
  }

  @Override
  public boolean create(User user,
                        Wallet wallet) {
    UserEntity createdUser = userRepository.save(userMapper.toUserEntity(user));

    TransactionPinEntity createdTransactionPin =
        transactionPinRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));

    wallet.setUser(userMapper.toCoreUser(createdUser));
    wallet.setTransactionPin(transactionPinMapper.toCoreTransactionPin(createdTransactionPin));


    walletRepository.save(
        walletMapper.toWalletEntity(wallet)
    );

    return true;
  }
}
