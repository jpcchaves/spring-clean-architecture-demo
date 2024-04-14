package com.cleanarch.infrastructure.service;

import com.cleanarch.core.domain.User;
import com.cleanarch.core.domain.Wallet;
import com.cleanarch.infrastructure.dto.user.UserCreateRequestDTO;
import com.cleanarch.infrastructure.dto.user.UserResponseDTO;
import com.cleanarch.infrastructure.gatewayimpl.CreateUserGatewayImpl;
import com.cleanarch.infrastructure.mapper.UserMapper;
import com.cleanarch.infrastructure.mapper.WalletMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final CreateUserGatewayImpl createUserGatewayImpl;
  private final UserMapper userMapper;
  private final WalletMapper walletMapper;
  public UserServiceImpl(CreateUserGatewayImpl createUserGatewayImpl,
                         UserMapper userMapper,
                         WalletMapper walletMapper) {
    this.createUserGatewayImpl = createUserGatewayImpl;
    this.userMapper = userMapper;
    this.walletMapper = walletMapper;
  }

  @Override
  public UserResponseDTO create(UserCreateRequestDTO userCreateRequestDTO) {
    User user = userMapper.toCoreUser(userCreateRequestDTO);
    Wallet wallet = walletMapper.toCoreWallet(userCreateRequestDTO.getWalletRequestDTO());

    createUserGatewayImpl.create(
        user,
        wallet
    );

    return userMapper.toUserResponseDTO(user);
  }
}
