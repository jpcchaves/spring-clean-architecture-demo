package com.cleanarch.core.domain;

import com.cleanarch.core.domain.enums.UserTypeEnum;
import com.cleanarch.core.exception.InsufficientBalanceException;
import com.cleanarch.core.exception.UnauthorizedTransferException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private User user;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id,
                  BigDecimal balance,
                  User user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet(BigDecimal balance,
                  User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance = balance.add(value);
    }

    public void transfer(BigDecimal value) {
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER) {
            throw new UnauthorizedTransferException(ErrorCodeEnum.TR0001.getCode(), ErrorCodeEnum.TR0001.getMessage());
        }

        if(this.balance.compareTo(value) < 0) {
            throw new InsufficientBalanceException(ErrorCodeEnum.TR0002.getCode(), ErrorCodeEnum.TR0002.getMessage());
        }

        this.balance = this.balance.subtract(value);
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance = balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
