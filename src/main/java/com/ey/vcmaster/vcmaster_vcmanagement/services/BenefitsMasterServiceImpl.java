package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitTypeDto;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.BenefitType;
import com.ey.vcmaster.vcmaster_vcmanagement.exception.VcMasterException;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.BenefitTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class BenefitsMasterServiceImpl implements BenefitsMasterService {
    private static final Logger logger = LogManager.getLogger(BenefitsMasterServiceImpl.class);
    private final BenefitTypeRepository benefitTypeRepository;

    public BenefitsMasterServiceImpl(BenefitTypeRepository benefitTypeRepository) {
        this.benefitTypeRepository = benefitTypeRepository;
    }

    @Override
    public List<BenefitTypeDto> getBenefitTypes(Locale locale) {
        try {
            String lang = locale.getLanguage();
            List<BenefitType> benefitTypes = benefitTypeRepository.findAll();
            return benefitTypeRepository.findAll().stream().map(benefitType ->
            {
                switch (lang){
                case "en":
                    return new BenefitTypeDto(benefitType.getBenId(), benefitType.getBenName(), benefitType.getBenDesc());
                    case "pt":
                    return new BenefitTypeDto(benefitType.getBenId(), benefitType.getBenNamePt(), benefitType.getBenDescPt());
                    default:
                    logger.warn("Unsupported language: {}", lang);
                    return new BenefitTypeDto(benefitType.getBenId(), benefitType.getBenName(), benefitType.getBenDesc());
            }
            }).toList();
        } catch (Exception ex) {
            throw new VcMasterException("Error fetching benefit types");
        }
    }
}
