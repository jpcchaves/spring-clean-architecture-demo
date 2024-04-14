package com.cleanarch.infrastructure.persistence.entity;

import com.cleanarch.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true, length = 70)
    private String email;


    @Column(nullable = false, unique = true, length = 15)
    private String taxNumber;
    @Column(nullable = false, length = 70)
    private String fullName;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserEntity() {
    }

    public UserEntity(UUID id,
                      String email,
                      String taxNumber,
                      String fullName,
                      UserTypeEnum type) {
        this.id = id;
        this.email = email;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    public UserEntity(UUID id,
                      String email,
                      String taxNumber,
                      String fullName,
                      UserTypeEnum type,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity(String email,
                      String taxNumber,
                      String fullName,
                      UserTypeEnum type) {
        this.email = email;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
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

        UserEntity that = (UserEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(taxNumber, that.taxNumber)) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (type != that.type) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        return Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
