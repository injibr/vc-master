package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.CreditApplication;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, UUID> {

    Optional<CreditApplication> findByCpfNumberAndApplicationTypeAndStatusIn(String cpfNumber, String applicationType, List<ApplicationStatus> statuses);

    List<CreditApplication> findByCpfNumber(String cpfNumber);

    Optional<CreditApplication> findByBankAppId(String bankAppId);
}
