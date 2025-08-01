package com.ey.vcmaster.vcmaster_vcmanagement.repositories;

import com.ey.vcmaster.vcmaster_vcmanagement.entity.DocumentSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSourceRepository extends JpaRepository<DocumentSource, Long> {
}
