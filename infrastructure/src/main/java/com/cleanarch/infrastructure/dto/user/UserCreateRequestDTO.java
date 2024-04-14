package com.cleanarch.infrastructure.dto.user;

import com.cleanarch.core.domain.enums.UserTypeEnum;

public class UserCreateRequestDTO {
  private String email;
  private String password;
  private String taxNumber;
  private String fullName;
  private UserTypeEnum type;
  private String pin;

  public UserCreateRequestDTO() {
  }

  public UserCreateRequestDTO(String email,
                              String password,
                              String taxNumber,
                              String fullName,
                              UserTypeEnum type,
                              String pin) {
    this.email = email;
    this.password = password;
    this.taxNumber = taxNumber;
    this.fullName = fullName;
    this.type = type;
    this.pin = pin;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UserTypeEnum getType() {
    return type;
  }

  public void setType(UserTypeEnum type) {
    this.type = type;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  @Override
  public String toString() {
    return "UserCreateRequestDTO{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", taxNumber='" + taxNumber + '\'' +
        ", fullName='" + fullName + '\'' +
        ", type=" + type +
        ", pin='" + pin + '\'' +
        '}';
  }
}
