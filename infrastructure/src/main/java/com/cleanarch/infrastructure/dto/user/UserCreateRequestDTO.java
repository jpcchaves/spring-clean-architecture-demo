package com.cleanarch.infrastructure.dto.user;

import com.cleanarch.core.domain.TaxNumber;
import com.cleanarch.core.domain.enums.UserTypeEnum;

public class UserCreateRequestDTO {
  private String email;
  private String password;
  private TaxNumber taxNumber;
  private String fullName;
  private UserTypeEnum type;
  private String pin;

  public UserCreateRequestDTO() {
  }

  public UserCreateRequestDTO(String email,
                              String password,
                              TaxNumber taxNumber,
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

  public TaxNumber getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(TaxNumber taxNumber) {
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
}
