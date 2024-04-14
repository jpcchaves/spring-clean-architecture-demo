package com.cleanarch.infrastructure.mapper;

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
    return mapperUtils.parseObject(user, UserEntity.class);
  }

  public User toCoreUser(UserCreateRequestDTO userRequestDTO) {
    return mapperUtils.parseObject(userRequestDTO, User.class);
  }

  public User toCoreUser(UserEntity userEntity) {
    return mapperUtils.parseObject(userEntity, User.class);
  }

  public UserResponseDTO toUserResponseDTO(User user) {
    return mapperUtils.parseObject(user, UserResponseDTO.class);
  }
}
