INSERT INTO master.benefit_type
( ben_name, ben_desc, ben_name_pt, ben_desc_pt)
VALUES( 'Rural Credit', 'Rural Credit desc', 'Crédito Rural', 'Descrição do Crédito Rural');
INSERT INTO master.benefit_type
(ben_name, ben_desc, ben_name_pt, ben_desc_pt)
VALUES('Fishery Credit', 'Coming soon...', 'Crédito Pesqueiro', 'em breve...');

INSERT INTO master.document_source
(doc_source_name)
VALUES('CAR');
INSERT INTO master.document_source
(doc_source_name)
VALUES('CAF');
INSERT INTO master.document_source
(doc_source_name)
VALUES('CCIR');

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Rural property registration', 'Cadastro de imóvel rural', 'Rural property registration', 'Cadastro de imóvel rural', false, 1);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('CAR Document', 'Documento CAR', 'CAR (Rural Environmental Registry)', 'Cadastro Ambiental Rural', true, 2);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('CCIR Document', 'Documento CCIR', 'CCIR (Rural Property Registration Certificate)', 'Certificado de Cadastro de Imóvel Rural', true, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Proof of income', 'Comprovante de renda', 'Evaluate what type of document the Bank considers for a rural producer without a relationship with the company.', 'Avaliar qual tipo de documento o Banco considera para um produtor rural sem vínculo com a empresa.', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Marriage certificate', 'Certidão de Casamento', 'Marriage Certificate', 'Certidão de Casamento', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Rural producer card', 'Carteira de Produtor Rural', 'Rural producer card', 'Carteira de Produtor Rural', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('RG and CPF', 'RG e CPF', 'RG and CPF', 'RG e CPF', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Proof of residence', 'Comprovante de residência', 'Proof of residence', 'Comprovante de residência', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Declaration of Eligibility for PRONAF (DAP)', 'Declaração de Elegibilidade ao PRONAF (DAP)', 'Declaration of Eligibility for PRONAF (DAP)', 'Declaração de Elegibilidade ao PRONAF (DAP)', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Lease agreement', 'Contrato de locação', 'Lease agreement', 'Contrato de locação', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('ITR', 'ITR', 'ITR', 'ITR', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Property and real estate documents', 'Documentos de propriedade e imóveis', 'Property and real estate documents', 'Documentos de propriedade e imóveis', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Water grant (if irrigation)', 'Subvenção de água (se for irrigação)', 'Water grant (if irrigation)', 'Subvenção de água (se for irrigação)', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Environmental license or waiver', 'Licença ou dispensa ambiental', 'Environmental license or waiver', 'Licença ou dispensa ambiental', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Licenses issued, rectified, renewed, Abios, miscellaneous authorizations and ASVs', 'Licenças emitidas, retificadas, renovadas, Abios, autorizações diversas e ASVs', 'Licenses issued, rectified, renewed, Abios, miscellaneous authorizations and ASVs', 'Licenças emitidas, retificadas, renovadas, Abios, autorizações diversas e ASVs', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Agricultural or livestock production', 'Produção agrícola ou pecuária', 'Agricultural or livestock production', 'Produção agrícola ou pecuária', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Demonstrative and sanitary control document on animal transit movement', 'Documento demonstrativo e de controle sanitário sobre movimentação de animais em trânsito', 'Demonstrative and sanitary control document on animal transit movement', 'Documento demonstrativo e de controle sanitário sobre movimentação de animais em trânsito', false, 3);

INSERT INTO master.benefit_document
(ben_doc_name, ben_doc_name_pt, ben_doc_desc, ben_doc_desc_pt, is_vc, doc_source_id)
VALUES('Environmental Statement - in states that request this document', 'Declaração Ambiental - nos estados que solicitarem este documento', 'Environmental Statement - in states that request this document', 'Declaração Ambiental - nos estados que solicitarem este documento', false, 3);



INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 2);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 3);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 4);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 5);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 6);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(1, 7);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(2, 2);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(2, 3);
INSERT INTO master.benefit_document_mapping
(ben_id, ben_doc_id)
VALUES(2, 4);