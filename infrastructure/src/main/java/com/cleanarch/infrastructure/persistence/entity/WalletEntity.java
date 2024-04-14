package com.cleanarch.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "wallets")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "transaction_pin_id")
    private TransactionPinEntity transactionPinId;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WalletEntity() {
    }

    public WalletEntity(Long id,
                        BigDecimal balance,
                        UserEntity userId,
                        TransactionPinEntity transactionPinId,
                        LocalDateTime createdAt,
                        LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
        this.transactionPinId = transactionPinId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public WalletEntity(BigDecimal balance,
                        UserEntity userId,
                        TransactionPinEntity transactionPinId) {
        this.balance = balance;
        this.userId = userId;
        this.transactionPinId = transactionPinId;
        this.createdAt = LocalDateTime.now();
    }

    public WalletEntity(Long id,
                        BigDecimal balance,
                        UserEntity userId,
                        TransactionPinEntity transactionPinId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
        this.transactionPinId = transactionPinId;
        this.createdAt = LocalDateTime.now();
    }

    public WalletEntity(BigDecimal balance,
                        UserEntity userEntity,
                        TransactionPinEntity transactionPinEntity,
                        LocalDateTime createdAt,
                        LocalDateTime updatedAt) {
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public TransactionPinEntity getTransactionPinId() {
        return transactionPinId;
    }

    public void setTransactionPinId(TransactionPinEntity transactionPinId) {
        this.transactionPinId = transactionPinId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        WalletEntity that = (WalletEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(balance, that.balance) && Objects.equals(userId, that.userId) && Objects.equals(transactionPinId, that.transactionPinId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, userId, transactionPinId, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
            "id=" + id +
            ", balance=" + balance +
            ", userId=" + userId +
            ", transactionPinId=" + transactionPinId +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
