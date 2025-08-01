package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.UploadedDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FileStorageService {
    Map<String, Object> storeFile(MultipartFile file, String cpfNumber, String applicationId, String documentName);
    Map<String, Object> getPreSignedUrl(UUID id);
    Map<String, Object> updateFile(UUID id, MultipartFile file);
    List<UploadedDocument> getAllFilesByCpfAndApplicationId(String cpfNumber, String applicationId) throws IOException;
}
