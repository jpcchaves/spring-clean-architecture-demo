package com.cleanarch.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}
