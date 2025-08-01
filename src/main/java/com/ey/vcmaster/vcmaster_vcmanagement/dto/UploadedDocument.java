package com.ey.vcmaster.vcmaster_vcmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UploadedDocument {
    UUID id;
    String documentName;
    String fileKey;
    String cpfNumber;
    String applicationId;
}
