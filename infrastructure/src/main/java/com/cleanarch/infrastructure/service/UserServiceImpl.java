package com.cleanarch.infrastructure.service;

import com.cleanarch.core.domain.User;
import com.cleanarch.infrastructure.dto.user.UserCreateRequestDTO;
import com.cleanarch.infrastructure.dto.user.UserResponseDTO;
import com.cleanarch.infrastructure.mapper.UserMapper;
import com.cleanarch.infrastructure.mapper.WalletMapper;
import com.cleanarch.usecase.CreateUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;
  private final CreateUserUseCase createUserUseCase;
  private final WalletMapper walletMapper;
  public UserServiceImpl(UserMapper userMapper,
                         CreateUserUseCase createUserUseCase,
                         WalletMapper walletMapper) {
    this.userMapper = userMapper;
    this.createUserUseCase = createUserUseCase;
    this.walletMapper = walletMapper;
  }

  @Override
  public UserResponseDTO create(UserCreateRequestDTO userCreateRequestDTO) {
    User user = userMapper.toCoreUser(userCreateRequestDTO);

    createUserUseCase.create(user, userCreateRequestDTO.getPin());

    return userMapper.toUserResponseDTO(user);
  }
}
