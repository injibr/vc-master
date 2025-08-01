package com.ey.vcmaster.vcmaster_vcmanagement.dto;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.ApplicationStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationDTO {
    private UUID id;
    private String cpfNumber;
    private String applicationType;
    private ApplicationStatus status;
    private String bankAppId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime submittedOn;
}
