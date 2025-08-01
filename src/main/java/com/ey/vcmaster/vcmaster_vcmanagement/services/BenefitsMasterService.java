package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitTypeDto;

import java.util.List;
import java.util.Locale;

public interface BenefitsMasterService {

    public List<BenefitTypeDto> getBenefitTypes(Locale locale);

}
