package com.cleanarch.infrastructure.persistence.entity;

import com.cleanarch.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_wallet")
    private WalletEntity fromWallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_wallet")
    private WalletEntity toWallet;

    @Column(nullable = false)
    private BigDecimal transactionValue;
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id,
                             WalletEntity fromWallet,
                             WalletEntity toWallet,
                             BigDecimal transactionValue,
                             TransactionStatusEnum status) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.transactionValue = transactionValue;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WalletEntity getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(WalletEntity fromWallet) {
        this.fromWallet = fromWallet;
    }

    public WalletEntity getToWallet() {
        return toWallet;
    }

    public void setToWallet(WalletEntity toWallet) {
        this.toWallet = toWallet;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(fromWallet, that.fromWallet)) return false;
        if (!Objects.equals(toWallet, that.toWallet)) return false;
        if (!Objects.equals(transactionValue, that.transactionValue))
            return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (fromWallet != null ? fromWallet.hashCode() : 0);
        result = 31 * result + (toWallet != null ? toWallet.hashCode() : 0);
        result = 31 * result + (transactionValue != null ? transactionValue.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", fromWallet=" + fromWallet +
                ", toWallet=" + toWallet +
                ", transactionValue=" + transactionValue +
                ", status=" + status +
                '}';
    }
}
