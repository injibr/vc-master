package com.ey.vcmaster.vcmaster_vcmanagement.services;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.DocumentSourceDto;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.DocumentSource;
import com.ey.vcmaster.vcmaster_vcmanagement.repositories.DocumentSourceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentSourceServiceImpl implements DocumentSourceService{
    private final DocumentSourceRepository documentSourceRepository;

    public DocumentSourceServiceImpl(DocumentSourceRepository documentSourceRepository) {
        this.documentSourceRepository = documentSourceRepository;
    }

    @Override
    public List<DocumentSourceDto> getAllDocumentSources() {
        List<DocumentSource> documentSources = documentSourceRepository.findAll();
        return documentSources.stream().map(documentSource -> new DocumentSourceDto(
                documentSource.getDocSourceId(),
                documentSource.getDocSourceName()
        )).toList();
    }
}
