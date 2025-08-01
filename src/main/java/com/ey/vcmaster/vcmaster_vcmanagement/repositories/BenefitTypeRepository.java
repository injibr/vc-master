package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BenefitTypeRepository extends JpaRepository<BenefitType, UUID> {
}
