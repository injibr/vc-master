package com.ey.vcmaster.vcmaster_vcmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stored_file_transaction", schema = "master")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoredFileTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileKey;
    private String storedFileId;
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
