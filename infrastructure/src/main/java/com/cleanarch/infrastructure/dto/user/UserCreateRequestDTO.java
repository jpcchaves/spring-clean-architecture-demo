package com.cleanarch.infrastructure.dto.user;

import com.cleanarch.core.domain.TaxNumber;
import com.cleanarch.core.domain.enums.UserTypeEnum;
import com.cleanarch.infrastructure.dto.wallet.WalletRequestDTO;

public class UserCreateRequestDTO {
  private String email;
  private String password;
  private TaxNumber taxNumber;
  private String fullName;
  private UserTypeEnum type;
  private WalletRequestDTO walletRequestDTO;

  public UserCreateRequestDTO() {
  }

  public UserCreateRequestDTO(String email,
                              String password,
                              TaxNumber taxNumber,
                              String fullName,
                              UserTypeEnum type,
                              WalletRequestDTO walletRequestDTO) {
    this.email = email;
    this.password = password;
    this.taxNumber = taxNumber;
    this.fullName = fullName;
    this.type = type;
    this.walletRequestDTO = walletRequestDTO;
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

  public WalletRequestDTO getWalletRequestDTO() {
    return walletRequestDTO;
  }

  public void setWalletRequestDTO(WalletRequestDTO walletRequestDTO) {
    this.walletRequestDTO = walletRequestDTO;
  }
}
