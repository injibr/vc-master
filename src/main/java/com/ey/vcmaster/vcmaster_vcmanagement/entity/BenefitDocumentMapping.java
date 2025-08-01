package com.ey.vcmaster.vcmaster_vcmanagement.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "benefit_document_mapping", schema = "master")
public class BenefitDocumentMapping {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ben_id", referencedColumnName = "ben_id")
    private BenefitType benefitType;

    @ManyToOne
    @JoinColumn(name = "ben_doc_id", referencedColumnName = "ben_doc_id")
    private BenefitDocument benefitDocument;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }

    public BenefitDocument getBenefitDocument() {
        return benefitDocument;
    }

    public void setBenefitDocument(BenefitDocument benefitDocument) {
        this.benefitDocument = benefitDocument;
    }
}
