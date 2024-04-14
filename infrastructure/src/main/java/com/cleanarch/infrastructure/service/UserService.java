package com.cleanarch.infrastructure.service;

import com.cleanarch.infrastructure.dto.user.UserCreateRequestDTO;
import com.cleanarch.infrastructure.dto.user.UserResponseDTO;

public interface UserService {
  UserResponseDTO create(UserCreateRequestDTO userDTO);
}
