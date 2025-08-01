package com.ey.vcmaster.vcmaster_vcmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "benefit_type", schema = "master")
@Data
public class BenefitType {

    @Id
    @Column(name = "ben_id")
    private Long benId;

    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "ben_name")
    private String benName;

    @Column(name = "ben_desc")
    private String benDesc;

    @Column(name = "ben_name_pt")
    private String benNamePt;

    @Column(name = "ben_desc_pt")
    private String benDescPt;

    // Relationship: Many-to-many with BenefitDocument via BenefitDocumentMapping
    @ManyToMany
    @JoinTable(
            name = "benefit_document_mapping",
            schema = "master",
            joinColumns = @JoinColumn(name = "ben_id"),
            inverseJoinColumns = @JoinColumn(name = "ben_doc_id")
    )
    private Set<BenefitDocument> benefitDocuments;
}
