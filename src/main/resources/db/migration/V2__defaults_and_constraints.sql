ALTER TABLE livraison
    ADD COLUMN client_id BIGINT,
    ADD COLUMN chauffeur_id BIGINT,
    ADD COLUMN vehicule_id BIGINT;

ALTER TABLE vehicule
    ADD COLUMN chauffeur_id BIGINT;

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
    ADD CONSTRAINT fk_chauffeur_vehicle
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);

ALTER TABLE chauffeur
    MODIFY COLUMN is_disponible BOOLEAN DEFAULT true;

ALTER TABLE livraison
    MODIFY COLUMN statut VARCHAR(50) DEFAULT 'ENATTENTE';

ALTER TABLE vehicule
    MODIFY COLUMN disponible BOOLEAN DEFAULT true;

ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite CHECK (capacite > 0);