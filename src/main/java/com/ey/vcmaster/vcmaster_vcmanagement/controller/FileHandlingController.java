package com.ey.vcmaster.vcmaster_vcmanagement.controller;

import com.ey.vcmaster.vcmaster_vcmanagement.response.ApiResponse;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ResponseBuilder;
import com.ey.vcmaster.vcmaster_vcmanagement.services.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileHandlingController {

    private final FileStorageService fileStorageService;

    public FileHandlingController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("cpfNumber") String cpfNumber,
            @RequestParam("applicationId") String applicationId,
            @RequestParam("documentName") String documentName) {

        try {
            var result = this.fileStorageService.storeFile(file, cpfNumber, applicationId, documentName);
            return ResponseBuilder.success(result, "File uploaded successfully");
        } catch (Exception e) {
            return ResponseBuilder.error(HttpStatus.BAD_REQUEST, "File upload failed: " + e.getMessage(), null);
        }
    }

    @GetMapping("/presigned-url/{id}")
    public ResponseEntity<ApiResponse<Object>> getPreSignedUrl(@PathVariable UUID id) {
        try {
            var result = this.fileStorageService.getPreSignedUrl(id);
            return ResponseBuilder.success(result, "PreSigned URL retrieved");
        } catch (Exception e) {
            return ResponseBuilder.error(HttpStatus.BAD_REQUEST, "Failed to retrieve PreSigned URL: " + e.getMessage(), null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Object>> updateFile(
            @PathVariable("id") UUID id,
            @RequestParam("file") MultipartFile file) {
        try {
            var result = this.fileStorageService.updateFile(id, file);
            return ResponseBuilder.success(result, "File updated successfully");
        } catch (Exception e) {
            return ResponseBuilder.error(HttpStatus.BAD_REQUEST, "File update failed: " + e.getMessage(), null);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Object>> getAllFilesByCpfAndApplicationId(
            @RequestParam("cpfNumber") String cpfNumber,
            @RequestParam("applicationId") String applicationId) {
        try {
            var result = this.fileStorageService.getAllFilesByCpfAndApplicationId(cpfNumber, applicationId);
            return ResponseBuilder.success(result, "Documents list retrieved successfully");
        } catch (IOException e) {
            return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve document list: " + e.getMessage(), null);
        }
    }
}
