--liquibase formatted sql logicalFilePath:db.changelog-001.baseline-ddl.sql

--changeset jackson.rodrigues:db.changelog-001.baseline-ddl.sql

CREATE TABLE pet_db.address
(
    id BIGINT(20) NOT NULL,
    `number` BIGINT(20),
    street          VARCHAR(200) NOT NULL,
    district_area   VARCHAR(100) NOT NULL,
    complement      VARCHAR(50) NOT NULL,
    reference_point VARCHAR(200) NOT NULL,
    city            VARCHAR(50) NOT NULL,
    `state`           VARCHAR(50) NOT NULL,
    country         VARCHAR(50) NOT NULL,
    CEP             VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pet_db.role (
    id BIGINT(20) NOT NULL,
    `role` varchar(255) NOT NULL,
    PRIMARY KEY (id));

create table pet_db.user
(
    id BIGINT(20) NOT NULL,
    cnpj varchar(255),
    cpf varchar(255),
    email varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    icon_url varchar(255),
    last_name varchar(255)NOT NULL,
    mobile_phone varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    picture_url varchar(255),
    PRIMARY KEY (id));

CREATE TABLE pet_db.user_address (
    user_id BIGINT(20) NOT NULL,
    address_id BIGINT(20) NOT NULL,
    PRIMARY KEY (user_id, address_id));

CREATE TABLE pet_db.user_role (
    user_id BIGINT(20) NOT NULL,
    role_id BIGINT(20) NOT NULL,
    PRIMARY KEY (user_id, role_id));

ALTER TABLE pet_db.user_address ADD CONSTRAINT fk_address_id
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE;

ALTER TABLE pet_db.user_address ADD CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE;

ALTER TABLE pet_db.user_role ADD CONSTRAINT fk_role_id
    FOREIGN KEY (role_id) REFERENCES `role`(id) ON DELETE CASCADE;

ALTER TABLE user_role ADD CONSTRAINT fk_user_id_001
    FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE;