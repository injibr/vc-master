package com.ey.vcmaster.vcmaster_vcmanagement.controller;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.CreditApplicationDTO;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ResponseBuilder;
import com.ey.vcmaster.vcmaster_vcmanagement.services.CreditApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/credit-applications")
@RequiredArgsConstructor
public class CreditApplicationController {

    private final CreditApplicationService service;

    @PostMapping
    public ResponseEntity<?> createApplication(@Valid @RequestBody CreditApplicationDTO dto) {
        return ResponseBuilder.success(service.createApplication(dto), "Successfully created application");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplication(@PathVariable UUID id, @RequestBody CreditApplicationDTO dto) {
        CreditApplicationDTO updatedApplication = service.updateApplication(id, dto);
        return ResponseBuilder.success(updatedApplication, "Successfully updated application");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationById(@PathVariable UUID id) {
        return ResponseBuilder.success(service.getApplicationById(id), "Successfully fetched application");
    }

    @GetMapping("/list")
    public ResponseEntity<?> getApplicationsByCpfNumber(@RequestParam String cpfNumber) {
        return ResponseBuilder.success(service.getApplicationsByCpfNumber(cpfNumber), "Successfully fetched applications");
    }

    @PutMapping("/bank/{bankAppId}")
    public ResponseEntity<?> updateApplicationByBankAppId(@PathVariable String bankAppId, @Valid @RequestBody CreditApplicationDTO dto) {
        return ResponseBuilder.success(service.updateApplicationByBankAppId(bankAppId, dto), "Successfully updated application by bankAppId");
    }
}
