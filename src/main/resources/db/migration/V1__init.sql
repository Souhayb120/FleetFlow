CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(100) NOT NULL,
                        email VARCHAR(150),
                        phone VARCHAR(30)
);

CREATE TABLE chauffeur (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(100) NOT NULL,
                           phone VARCHAR(30),
                           permis_type VARCHAR(50),
                           is_disponible BOOLEAN
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          matricule VARCHAR(50) UNIQUE NOT NULL,
                          capacite INT,
                          statut VARCHAR(50) ,
                          type VARCHAR(50)
);


CREATE TABLE livraison (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_livraison DATE,
                           adresse_depart VARCHAR(255),
                           adresse_destination VARCHAR(255),
                           statut VARCHAR(50)
);