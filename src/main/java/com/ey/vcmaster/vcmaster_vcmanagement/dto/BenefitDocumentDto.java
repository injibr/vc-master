package com.ey.vcmaster.vcmaster_vcmanagement.dto;

public record BenefitDocumentDto(Long benDocId,
                                 String benDocName,
                                 String benDocDesc,
                                 Boolean isVc) {
}
