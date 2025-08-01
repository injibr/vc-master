package com.ey.vcmaster.vcmaster_vcmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "benefit_document", schema = "master")
public class BenefitDocument {

    @Id
    @Column(name = "ben_doc_id")
    private Long benDocId;

    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "ben_doc_name")
    private String benDocName;

    @Column(name = "ben_doc_desc")
    private String benDocDesc;

    @Column(name = "is_vc")
    private Boolean isVc;

    @Column(name = "ben_doc_name_pt")
    private String benDocNamePt;

    @Column(name = "ben_doc_desc_pt")
    private String benDocDescPt;

    // Relationship: Many-to-one with DocumentSource
    @ManyToOne
    @JoinColumn(name = "doc_source_id", referencedColumnName = "doc_source_id")
    private DocumentSource documentSource;

    // Relationship: Many-to-many with BenefitType via BenefitDocumentMapping
    @ManyToMany(mappedBy = "benefitDocuments")
    private Set<BenefitType> benefitTypes;

    public Long getBenDocId() {
        return benDocId;
    }

    public void setBenDocId(Long benDocId) {
        this.benDocId = benDocId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBenDocName() {
        return benDocName;
    }

    public void setBenDocName(String benDocName) {
        this.benDocName = benDocName;
    }

    public String getBenDocDesc() {
        return benDocDesc;
    }

    public void setBenDocDesc(String benDocDesc) {
        this.benDocDesc = benDocDesc;
    }

    public Boolean getVc() {
        return isVc;
    }

    public void setVc(Boolean vc) {
        isVc = vc;
    }

    public DocumentSource getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(DocumentSource documentSource) {
        this.documentSource = documentSource;
    }

    public Set<BenefitType> getBenefitTypes() {
        return benefitTypes;
    }

    public void setBenefitTypes(Set<BenefitType> benefitTypes) {
        this.benefitTypes = benefitTypes;
    }

    public String getBenDocNamePt() {
        return benDocNamePt;
    }

    public void setBenDocNamePt(String benDocNamePt) {
        this.benDocNamePt = benDocNamePt;
    }

    public String getBenDocDescPt() {
        return benDocDescPt;
    }

    public void setBenDocDescPt(String benDocDescPt) {
        this.benDocDescPt = benDocDescPt;
    }
}
