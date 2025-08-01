package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitDocument;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitDocumentMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BenefitDocumentMappingRepository extends JpaRepository<BenefitDocumentMapping, UUID> {

    // Custom query to fetch BenefitDocument list by ben_id
    @Query("SELECT bdm.benefitDocument FROM BenefitDocumentMapping bdm WHERE bdm.benefitType.benId = :benId")
    List<BenefitDocument> findBenefitDocumentsByBenefitId(@Param("benId") Long benId);
}
