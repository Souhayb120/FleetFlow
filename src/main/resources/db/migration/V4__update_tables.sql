CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(150),
                       password VARCHAR(255) NOT NULL
);

ALTER TABLE client
DROP COLUMN nom,
    DROP COLUMN email,
    DROP COLUMN id;

ALTER TABLE client
    ADD COLUMN id BIGINT PRIMARY KEY,
    ADD COLUMN age INT,
    ADD CONSTRAINT fk_client_user FOREIGN KEY (id) REFERENCES users(id);

ALTER TABLE chauffeur
DROP COLUMN nom,
    DROP COLUMN id;

ALTER TABLE chauffeur
    ADD COLUMN id BIGINT PRIMARY KEY,
    ADD CONSTRAINT fk_chauffeur_user FOREIGN KEY (id) REFERENCES users(id);