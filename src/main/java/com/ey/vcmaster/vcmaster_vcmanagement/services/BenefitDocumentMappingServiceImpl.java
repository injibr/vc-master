package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitDocument;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.BenefitDocumentMappingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitDocumentMappingServiceImpl implements BenefitDocumentMappingService {

    private final BenefitDocumentMappingRepository benefitDocumentMappingRepository;

    public BenefitDocumentMappingServiceImpl(BenefitDocumentMappingRepository benefitDocumentMappingRepository) {
        this.benefitDocumentMappingRepository = benefitDocumentMappingRepository;
    }


    @Override
    public List<BenefitDocument> getBenefitDocumentsByBenId(Long benId) {
        return benefitDocumentMappingRepository.findBenefitDocumentsByBenefitId(benId);
    }
}
