package com.ey.vcmaster.vcmaster_vcmanagement.controller;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.BenefitDocumentDto;
import com.ey.vcmaster.vcmaster_vcmanagement.dto.DocumentSourceDto;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ApiResponse;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ResponseBuilder;
import com.ey.vcmaster.vcmaster_vcmanagement.services.BenefitDocumentService;
import com.ey.vcmaster.vcmaster_vcmanagement.services.DocumentSourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class DocumentController {
    private final BenefitDocumentService benefitDocumentService;
    private final DocumentSourceService documentSourceService;

    public DocumentController(BenefitDocumentService documentService, DocumentSourceService documentSourceService) {
        this.benefitDocumentService = documentService;
        this.documentSourceService = documentSourceService;
    }

    @GetMapping("/getDocument/{benId}")
    public ResponseEntity<ApiResponse<List<BenefitDocumentDto>>> getDocument(@PathVariable("benId") Long benId, Locale locale) {
        var documents = this.benefitDocumentService.getDocuments(benId,locale);
        return ResponseBuilder.success(documents, "Successfully fetched documents");
    }

    @GetMapping("/getDocumentSources")
    public ResponseEntity<ApiResponse<List<DocumentSourceDto>>> getDocumentSources() {
        var documentSources = this.documentSourceService.getAllDocumentSources();
        return ResponseBuilder.success(documentSources, "Successfully fetched documents");
    }
}
