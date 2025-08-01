package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitDocumentDto;

import java.util.List;
import java.util.Locale;

public interface BenefitDocumentService {

    public List<BenefitDocumentDto> getDocuments(Long benefitType, Locale locale);
}
