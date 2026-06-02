CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(150),
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50)
);

CREATE TABLE client (
                        id BIGINT PRIMARY KEY,
                        phone VARCHAR(30),
                        age INT
);

CREATE TABLE chauffeur (
                           id BIGINT PRIMARY KEY,
                           phone VARCHAR(30),
                           permis_type VARCHAR(50),
                           is_disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          matricule VARCHAR(50) UNIQUE NOT NULL,
                          capacite INT,
                          livraisionStatut VARCHAR(50),
                          type VARCHAR(50)
);

CREATE TABLE livraison (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_livraison DATE,
                           adresse_depart VARCHAR(255),
                           adresse_destination VARCHAR(255),
                           livraisionStatut VARCHAR(50),
                           client_id BIGINT,
                           chauffeur_id BIGINT,
                           vehicule_id BIGINT
);