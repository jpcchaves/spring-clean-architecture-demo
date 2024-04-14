package com.cleanarch.infrastructure.persistence.repository;

import com.cleanarch.infrastructure.persistence.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPinRepository extends JpaRepository<TransactionPinEntity, Long> {
}
