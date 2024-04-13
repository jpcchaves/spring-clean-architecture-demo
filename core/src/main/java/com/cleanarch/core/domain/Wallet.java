package com.cleanarch.core.domain;

import com.cleanarch.core.domain.enums.UserTypeEnum;
import com.cleanarch.core.exception.InsufficientBalanceException;
import com.cleanarch.core.exception.UnauthorizedTransferException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id,
                  TransactionPin transactionPin,
                  BigDecimal balance,
                  User user) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet(TransactionPin transactionPin,
                  BigDecimal balance,
                  User user) {
        this.transactionPin = transactionPin;
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

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (!id.equals(wallet.id)) return false;
        if (!transactionPin.equals(wallet.transactionPin)) return false;
        if (!balance.equals(wallet.balance)) return false;
        if (!user.equals(wallet.user)) return false;
        if (!createdAt.equals(wallet.createdAt)) return false;
        return Objects.equals(updatedAt, wallet.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + transactionPin.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", transactionPin=" + transactionPin +
                ", balance=" + balance +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
