package com.cleanarch.infrastructure.dto.user;

public class UserResponseDTO {
  private String test;

  public UserResponseDTO() {
  }

  public UserResponseDTO(String test) {
    this.test = test;
  }

  public String getTest() {
    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }
}
