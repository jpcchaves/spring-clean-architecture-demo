package com.cleanarch.domain;

import com.cleanarch.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(UUID id,
                String email,
                String password,
                TaxNumber taxNumber,
                String fullName,
                UserTypeEnum type,
                TransactionPin transactionPin,
                LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }

    public User(String email,
                String password,
                TaxNumber taxNumber,
                String fullName,
                UserTypeEnum type,
                TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public TransactionPin getTransactionalPin() {
        return transactionPin;
    }

    public void setTransactionalPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
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

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (!taxNumber.equals(user.taxNumber)) return false;
        if (!fullName.equals(user.fullName)) return false;
        if (type != user.type) return false;
        if (!transactionPin.equals(user.transactionPin)) return false;
        if (!createdAt.equals(user.createdAt)) return false;
        return Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + taxNumber.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + transactionPin.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", taxNumber=" + taxNumber +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                ", transactionalPin=" + transactionPin +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
