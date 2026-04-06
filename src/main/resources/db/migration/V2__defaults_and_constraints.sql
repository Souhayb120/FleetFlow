
ALTER TABLE livraison
    ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_chauffeur
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_vehicule
        FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);


ALTER TABLE vehicle
    ADD CONSTRAINT fk_chauffeur_vehicle
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);


ALTER TABLE chauffeur
    ALTER COLUMN is_disponible BOOLEAN DEFAULT true;

ALTER TABLE livraison
    MODIFY COLUMN statut VARCHAR(50) DEFAULT 'ENATTENTE';

ALTER TABLE vehicle
    MODIFY COLUMN disponible BOOLEAN DEFAULT true;


ALTER TABLE vehicle
    ADD CONSTRAINT chk_capacite CHECK (capacite > 0);