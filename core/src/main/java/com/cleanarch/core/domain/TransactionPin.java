package com.cleanarch.core.domain;

import com.cleanarch.core.exception.InvalidTransactionPinException;
import com.cleanarch.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {
    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin() {
    }

    public TransactionPin(String pin) {
        setPin(pin);
        attempt = 3;
        blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin(String pin,
                          Integer attempt,
                          Boolean blocked) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        isValidPin(pin);
        this.pin = pin;
    }

    private void isValidPin(String pin) {
        if(pin.length() != 8) {
            throw new InvalidTransactionPinException(ErrorCodeEnum.TRP0001.getCode(), ErrorCodeEnum.TRP0001.getMessage());
        }
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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

        TransactionPin that = (TransactionPin) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!pin.equals(that.pin)) return false;
        if (!attempt.equals(that.attempt)) return false;
        if (!blocked.equals(that.blocked)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + pin.hashCode();
        result = 31 * result + attempt.hashCode();
        result = 31 * result + blocked.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransactionalPin{" +
                "id=" + id +
                ", pin='" + pin + '\'' +
                ", attempt=" + attempt +
                ", blocked=" + blocked +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
