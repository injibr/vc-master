package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.UploadedDocument;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.StoredFile;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.StoredFileTransaction;
import com.ey.vcmaster.vcmaster_vcmanagement.exception.VcMasterException;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.StoredFileRepository;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.StoredFileTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static software.amazon.awssdk.core.sync.RequestBody.fromBytes;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    private final StoredFileRepository storedFileRepository;

    private final S3Client s3Client;

    private final S3Presigner s3Presigner;

    private final StoredFileTransactionRepository storedFileTransactionRepository;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public Map<String, Object> storeFile(MultipartFile file, String cpfNumber, String applicationId, String documentName) {
        StoredFile existingFile = storedFileRepository.findByCpfNumberAndApplicationIdAndDocumentName(cpfNumber, applicationId, documentName);
        if (existingFile != null) {
            log.info("File with document name '{}' already exists for CPF: {} and Application ID: {}", documentName, cpfNumber, applicationId);
            throw new VcMasterException("File with this document name already exists for the given CPF and Application ID");
        }
        String key;
        try {
            key = uploadFileToS3(file);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to upload file", ex);
        }
        StoredFile storedFile = new StoredFile();
        storedFile.setFileKey(key);
        storedFile.setCpfNumber(cpfNumber);
        storedFile.setDocumentName(documentName);
        storedFile.setApplicationId(applicationId);
        storedFile = storedFileRepository.save(storedFile);

        // Add transaction log after file is saved
        logFileTransaction(storedFile);

        URL presignedUrl = generatePresignedUrl(key);

        Map<String, Object> response = new HashMap<>();
        response.put("id", storedFile.getId());
        response.put("presignedUrl", presignedUrl.toString());
        return response;
    }

    private String uploadFileToS3(MultipartFile file) throws IOException {
        UUID uuid = UUID.randomUUID();
        String key = "uploads/" + uuid + "-" + file.getOriginalFilename();

        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build(),
                fromBytes(file.getBytes()));
        return key;
    }

    private void logFileTransaction(StoredFile storedFile) {
        StoredFileTransaction transaction = StoredFileTransaction.builder()
                .fileKey(storedFile.getFileKey())
                .storedFileId(String.valueOf(storedFile.getId()))
                .createdAt(LocalDateTime.now())
                .build();
        storedFileTransactionRepository.save(transaction);
    }

    @Override
    public Map<String, Object> getPreSignedUrl(UUID id) {
        log.info("Retrieving pre-signed URL for file with UUID: {}", id);
        try {
            return storedFileRepository.findById(id)
                    .map(storedFile -> {
                        URL presignedUrl = generatePresignedUrl(storedFile.getFileKey());
                        Map<String, Object> response = new HashMap<>();
                        response.put("uuid", storedFile.getId());
                        response.put("presignedUrl", presignedUrl.toString());
                        return response;
                    })
                    .orElseThrow(() -> new VcMasterException("File not found for UUID: " + id));
        } catch (Exception e) {
            log.error("Error retrieving pre-signed URL for file with UUID: {}", id, e);
            throw new VcMasterException("Error retrieving pre-signed URL for file with UUID: " + id, e);
        }

    }

    @Override
    public Map<String, Object> updateFile(UUID id, MultipartFile file) {
        log.info("Updating file with ID: {}", id);
        StoredFile storedFile = storedFileRepository.findById(id)
                .orElseThrow(() -> new VcMasterException("File not found for ID: " + id));

        String key;
        try {
            key = uploadFileToS3(file);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to upload file", ex);
        }
        storedFile.setFileKey(key);
        storedFileRepository.save(storedFile);

        // Log the transaction
        logFileTransaction(storedFile);

        URL presignedUrl = generatePresignedUrl(key);

        Map<String, Object> response = new HashMap<>();
        response.put("id", storedFile.getId());
        response.put("presignedUrl", presignedUrl.toString());
        return response;
    }

    @Override
    public List<UploadedDocument> getAllFilesByCpfAndApplicationId(String cpfNumber, String applicationId) {
        var files = storedFileRepository.findAllByCpfNumberAndApplicationId(cpfNumber, applicationId);
        List<UploadedDocument> result = new java.util.ArrayList<>();
        for (StoredFile file : files) {
            UploadedDocument uploadedDocument = new UploadedDocument();
            uploadedDocument.setId(file.getId());
            uploadedDocument.setDocumentName(file.getDocumentName());
            uploadedDocument.setFileKey(file.getFileKey());
            uploadedDocument.setCpfNumber(file.getCpfNumber());
            uploadedDocument.setApplicationId(file.getApplicationId());
            result.add(uploadedDocument);
        }
        return result;
    }


    private URL generatePresignedUrl(String key) {
        String mimeType = URLConnection.guessContentTypeFromName(key);
        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .getObjectRequest(b -> b.bucket(bucketName).key(key)
                        .responseContentDisposition("inline")
                        .responseContentType(mimeType))
                .build();

        PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest);
        return presignedRequest.url();
    }
}