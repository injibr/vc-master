package com.ey.vcmaster.vcmaster_vcmanagement.services.impl;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.CreditApplicationDTO;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.ApplicationStatus;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.CreditApplication;
import com.ey.vcmaster.vcmaster_vcmanagement.exception.DuplicateActiveApplicationException;
import com.ey.vcmaster.vcmaster_vcmanagement.mapper.CreditApplicationMapper;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.CreditApplicationRepository;
import com.ey.vcmaster.vcmaster_vcmanagement.services.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditApplicationServiceImpl implements CreditApplicationService {

    private final CreditApplicationRepository repository;
    private final CreditApplicationMapper mapper;

    private static final List<ApplicationStatus> ACTIVE_STATUSES = Arrays.asList(ApplicationStatus.CREATED, ApplicationStatus.SUBMITTED, ApplicationStatus.IN_PROCESS);

    @Override
    @Transactional
    public CreditApplicationDTO createApplication(CreditApplicationDTO dto) {
        repository.findByCpfNumberAndApplicationTypeAndStatusIn(dto.getCpfNumber(), dto.getApplicationType(), ACTIVE_STATUSES)
                .ifPresent(existing -> {
                    throw new DuplicateActiveApplicationException("An active application already exists for the given CPF and application type.");
                });

        CreditApplication entity = mapper.toEntity(dto);
        entity.setStatus(ApplicationStatus.CREATED);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional
    public CreditApplicationDTO updateApplication(UUID id, CreditApplicationDTO dto) {
        CreditApplication entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Application not found"));

        if (dto.getStatus() == ApplicationStatus.SUBMITTED && (dto.getBankAppId() == null || dto.getBankAppId().isEmpty())) {
            throw new IllegalArgumentException("BankAppId is mandatory while submitting.");
        }
        mapper.updateCreditApplication(dto, entity);
        return mapper.toDto(repository.saveAndFlush(entity));
    }

    @Override
    public CreditApplicationDTO getApplicationById(UUID id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new IllegalArgumentException("Application not found"));
    }

    @Override
    public List<CreditApplicationDTO> getApplicationsByCpfNumber(String cpfNumber) {
        return mapper.toDtoList(repository.findByCpfNumber(cpfNumber));
    }

    @Override
    @Transactional
    public CreditApplicationDTO updateApplicationByBankAppId(String bankAppId, CreditApplicationDTO dto) {
        CreditApplication entity = repository.findByBankAppId(bankAppId).orElseThrow(() -> new IllegalArgumentException("Application not found"));
        mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }
}
