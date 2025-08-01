package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitDocument;

import java.util.List;

public interface BenefitDocumentMappingService {
    public List<BenefitDocument> getBenefitDocumentsByBenId(Long benId);
}
