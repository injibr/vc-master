package com.ey.vcmaster.vcmaster_vcmanagement.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "document_source", schema = "master")
public class DocumentSource {

    @Id
    @Column(name = "doc_source_id")
    private Long docSourceId;

    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "doc_source_name")
    private String docSourceName;

    // Relationship: One-to-many with BenefitDocument
    @OneToMany(mappedBy = "documentSource", cascade = CascadeType.ALL)
    private Set<BenefitDocument> benefitDocuments;

    public Long getDocSourceId() {
        return docSourceId;
    }

    public void setDocSourceId(Long docSourceId) {
        this.docSourceId = docSourceId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocSourceName() {
        return docSourceName;
    }

    public void setDocSourceName(String docSourceName) {
        this.docSourceName = docSourceName;
    }

    public Set<BenefitDocument> getBenefitDocuments() {
        return benefitDocuments;
    }

    public void setBenefitDocuments(Set<BenefitDocument> benefitDocuments) {
        this.benefitDocuments = benefitDocuments;
    }
}
