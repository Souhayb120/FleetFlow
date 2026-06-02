ALTER TABLE client
    ADD CONSTRAINT fk_client_user
        FOREIGN KEY (id) REFERENCES users(id);

ALTER TABLE chauffeur
    ADD CONSTRAINT fk_chauffeur_user
        FOREIGN KEY (id) REFERENCES users(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_chauffeur
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_vehicule
        FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);

ALTER TABLE vehicule
    ADD COLUMN chauffeur_id BIGINT;

ALTER TABLE vehicule
    ADD CONSTRAINT fk_chauffeur_vehicle
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);

ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite
        CHECK (capacite > 0);