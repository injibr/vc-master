package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.CreditApplicationDTO;

import java.util.List;
import java.util.UUID;

public interface CreditApplicationService {
    CreditApplicationDTO createApplication(CreditApplicationDTO dto);
    CreditApplicationDTO updateApplication(UUID id, CreditApplicationDTO dto);
    CreditApplicationDTO getApplicationById(UUID id);
    List<CreditApplicationDTO> getApplicationsByCpfNumber(String cpfNumber);
    CreditApplicationDTO updateApplicationByBankAppId(String bankAppId, CreditApplicationDTO dto);
}
