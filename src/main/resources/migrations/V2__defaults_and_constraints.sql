
ALTER TABLE livraison
ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id) REFERENCES client(id),

ADD CONSTRAINT fk_chauffeur
FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id),

ADD CONSTRAINT fk_vehicule
FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);


ALTER TABLE vehicle
ADD CONSTRAINT fk_chauffeur
FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);


ALTER TABLE chauffeur
    ALTER COLUMN isDisponible SET DEFAULT true;

ALTER TABLE livraison
    ALTER COLUMN statut SET DEFAULT 'ENATTENTE';

ALTER TABLE vehicle
    ALTER COLUMN disponible SET DEFAULT true;



ALTER TABLE vehicle
    ADD CONSTRAINT chk_capacite CHECK (capacite > 0);

