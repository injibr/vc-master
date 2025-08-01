-- After DB is created, connect to it and create schema
\connect vc_master

CREATE SCHEMA IF NOT EXISTS master AUTHORIZATION postgres;


CREATE TABLE master.benefit_type (
    id UUID DEFAULT gen_random_uuid() NOT NULL,
    ben_id BIGSERIAL PRIMARY KEY,
    ben_name VARCHAR(50),
    ben_name_pt VARCHAR(50),
    ben_desc VARCHAR(500),
    ben_desc_pt VARCHAR(500)
);

CREATE TABLE master.document_source (
    id UUID DEFAULT gen_random_uuid() NOT NULL,
    doc_source_id BIGSERIAL PRIMARY KEY,
    doc_source_name VARCHAR(50)
);

CREATE TABLE master.benefit_document (
    id UUID DEFAULT gen_random_uuid() NOT NULL,
    ben_doc_id BIGSERIAL PRIMARY KEY,
    ben_doc_name VARCHAR(100),
    ben_doc_name_pt VARCHAR(100),
    ben_doc_desc VARCHAR(500),
    ben_doc_desc_pt VARCHAR(500),
    is_vc BOOLEAN NOT NULL,
    doc_source_id BIGINT NOT NULL,
    CONSTRAINT fk_doc_source
        FOREIGN KEY (doc_source_id)
        REFERENCES master.document_source (doc_source_id)
        ON DELETE SET NULL
);

CREATE TABLE master.benefit_document_mapping (
    id UUID DEFAULT gen_random_uuid() NOT NULL,
    ben_id BIGINT NOT NULL,
    ben_doc_id BIGINT NOT NULL,
    CONSTRAINT fk_benefit
        FOREIGN KEY (ben_id)
        REFERENCES master.benefit_type (ben_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_benefit_document
        FOREIGN KEY (ben_doc_id)
        REFERENCES master.benefit_document (ben_doc_id)
        ON DELETE CASCADE
);

--CREATE TABLE master.stored_files (
--    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--    file_key VARCHAR(255) NOT NULL UNIQUE,
--    uploaded_at TIMESTAMP NOT NULL
--);
--
--ALTER TABLE master.stored_files ADD cpf_number varchar NULL;
--ALTER TABLE master.stored_files ADD rural_credit_id varchar NULL;
--ALTER TABLE master.stored_files ADD document_name varchar NULL;

CREATE TABLE master.stored_files (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    file_key VARCHAR(255) NOT NULL UNIQUE,
    cpf_number VARCHAR(100),
    application_id VARCHAR(100),
    document_name VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE master.stored_file_transaction (
    id BIGSERIAL PRIMARY KEY,
    file_key VARCHAR(255),
    stored_file_id VARCHAR(100),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE master.credit_application (
    id UUID PRIMARY KEY,
    cpf_number VARCHAR(255) NOT NULL,
    application_type VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    bank_app_id VARCHAR(255),
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP,
    submitted_on TIMESTAMP
);
