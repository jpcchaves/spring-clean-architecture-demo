package com.cleanarch.infrastructure.controller;

import com.cleanarch.infrastructure.dto.user.UserCreateRequestDTO;
import com.cleanarch.infrastructure.dto.user.UserResponseDTO;
import com.cleanarch.infrastructure.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> userResponseDTOResponseEntity(@RequestBody UserCreateRequestDTO requestDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(requestDTO));
  }
}
