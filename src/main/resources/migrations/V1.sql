
CREATE TABLE client (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE,
                        phone VARCHAR(20)
);

CREATE TABLE chauffeur (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(100) NOT NULL,
                           phone VARCHAR(20),
                           permis_type VARCHAR(50)
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          matricule VARCHAR(50) UNIQUE,
                          capacite INT,
                          disponible BOOLEAN DEFAULT TRUE,
                          type VARCHAR(50)
);

CREATE TABLE livraison (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_livraison DATE,
                           adresse_depart VARCHAR(255),
                           adresse_destination VARCHAR(255),
                           statut VARCHAR(50)
);