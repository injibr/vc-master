package com.ey.vcmaster.vcmaster_vcmanagement.controller;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitTypeDto;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ApiResponse;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ResponseBuilder;
import com.ey.vcmaster.vcmaster_vcmanagement.services.BenefitsMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class VcMasterController {

    private final BenefitsMasterService benefitsMasterService;

    public VcMasterController(BenefitsMasterService benefitsMasterService) {
        this.benefitsMasterService = benefitsMasterService;
    }

    @GetMapping("/getBenefitTypes")
    public ResponseEntity<ApiResponse<List<BenefitTypeDto>>> downloadDocument(Locale locale) {
        var benefits = this.benefitsMasterService.getBenefitTypes(locale);
        return ResponseBuilder.success(benefits, "Successfully fetched benefit types");
    }
}
