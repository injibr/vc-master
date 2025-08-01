package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.StoredFileTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredFileTransactionRepository extends JpaRepository<StoredFileTransaction, Long> {
}

