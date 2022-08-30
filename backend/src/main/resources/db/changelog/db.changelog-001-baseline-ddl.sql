--liquibase formatted sql logicalFilePath:db.changelog-001.baseline-ddl.sql

--changeset jackson.rodrigues:db.changelog-001.baseline-ddl.sql

CREATE TABLE pet_db.address
(
    id BIGINT(20) NOT NULL,
    number BIGINT(20),
    street          VARCHAR(200) NOT NULL,
    district_area   VARCHAR(100) NOT NULL,
    complement      VARCHAR(50) NOT NULL,
    reference_point VARCHAR(200) NOT NULL,
    city            VARCHAR(50) NOT NULL,
    state           VARCHAR(50) NOT NULL,
    country         VARCHAR(50) NOT NULL,
    CEP             VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);