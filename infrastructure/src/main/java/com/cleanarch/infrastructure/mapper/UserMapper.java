package com.cleanarch.infrastructure.mapper;

import com.cleanarch.core.domain.TaxNumber;
import com.cleanarch.core.domain.User;
import com.cleanarch.infrastructure.dto.user.UserCreateRequestDTO;
import com.cleanarch.infrastructure.dto.user.UserResponseDTO;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;
import com.cleanarch.infrastructure.utils.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  private final MapperUtils mapperUtils;

  public UserMapper(MapperUtils mapperUtils) {
    this.mapperUtils = mapperUtils;
  }

  public UserEntity toUserEntity(User user) {
    return new UserEntity(user.getEmail(),user.getTaxNumber().getValue(), user.getFullName(), user.getType());
  }

  public User toCoreUser(UserCreateRequestDTO userRequestDTO) throws Exception {
    return new User(userRequestDTO.getEmail(), userRequestDTO.getPassword(), new TaxNumber(userRequestDTO.getTaxNumber()), userRequestDTO.getFullName(), userRequestDTO.getType());
  }

  public User toCoreUser(UserEntity userEntity) {
    return mapperUtils.parseObject(userEntity, User.class);
  }

  public UserResponseDTO toUserResponseDTO(User user) {
    return mapperUtils.parseObject(user, UserResponseDTO.class);
  }
}
