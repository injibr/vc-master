package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitDocumentDto;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitDocument;
import com.ey.vcmaster.vcmaster_vcmanagement.exception.VcMasterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class BenefitDocumentServiceImpl implements BenefitDocumentService {
    private static final Logger logger = LogManager.getLogger(BenefitDocumentServiceImpl.class);
    private final BenefitDocumentMappingService benefitDocumentMappingService;

    public BenefitDocumentServiceImpl(BenefitDocumentMappingService benefitDocumentMappingService) {
        this.benefitDocumentMappingService = benefitDocumentMappingService;
    }

    public List<BenefitDocumentDto> getDocuments(Long benId, Locale locale) {
        try {
            String lang = locale.getLanguage();
            if (Objects.isNull(benId))
                throw new IllegalArgumentException();

            List<BenefitDocument> documentsByBenId = benefitDocumentMappingService.getBenefitDocumentsByBenId(benId);

            return documentsByBenId.stream().map(benefitDocument -> {
                switch (lang){
                    case "pt":
                        return new BenefitDocumentDto(
                                benefitDocument.getBenDocId(),
                                benefitDocument.getBenDocNamePt(),
                                benefitDocument.getBenDocDescPt(),
                                benefitDocument.getVc()
                        );
                    default:
                        return new BenefitDocumentDto(
                                benefitDocument.getBenDocId(),
                                benefitDocument.getBenDocName(),
                                benefitDocument.getBenDocDesc(),
                                benefitDocument.getVc()
                        );

                }


            }).toList();
        } catch (IllegalArgumentException ex) {
            logger.error("Invalid benefit type provided: {}", benId);
            throw new VcMasterException("Invalid benefit type provided: " + benId);
        }catch (Exception ex) {
            logger.error("An error occurred while fetching documents for benefit type {}: {}", benId, ex.getMessage());
            throw new VcMasterException("An error occurred while fetching documents for benefit type " + benId);
        }

    }
}
