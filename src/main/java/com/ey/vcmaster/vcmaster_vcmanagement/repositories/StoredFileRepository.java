package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.StoredFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StoredFileRepository extends JpaRepository<StoredFile, UUID> {
    List<StoredFile> findAllByCpfNumberAndApplicationId(String cpfNumber, String applicationId);
    StoredFile findByCpfNumberAndApplicationIdAndDocumentName(String cpfNumber, String applicationId, String documentName);
}
