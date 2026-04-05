package com.example.FleetFlow.services;

import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.LivraisonRepository;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import com.example.FleetFlow.repositories.vehculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class livraisionService {
    @Autowired
    private LivraisonRepository livraisionRepository;
    @Autowired
    private ChauffeurRepository chauffeurRepository;
    @Autowired
    private vehculeRepository vehiculeRepository;

    public Livraison creeLivraision(Livraison l){
        l.setStatut("EN_ATTENTE");
        return livraisionRepository.save(l);
    }
    public Livraison assigner(Long livraisonId, Integer chauffeurId, Long vehiculeId) {

        Livraison livraison = livraisionRepository.findById(livraisonId).get();
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).get();
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).get();
        chauffeur.setIsDisponible(false);
        vehicule.setDisponible(false);
        livraison.setStatut("Occuppier");

        livraison.setChauffeur(chauffeur);
        livraison.setVehicule(vehicule);

        return livraisionRepository.save(livraison);
    }
    public Livraison updateStatut(Long id, String statut) {

        Livraison livraison = livraisionRepository.findById(id).get();
        livraison.setStatut(statut);

        return livraisionRepository.save(livraison);
    }
    public List<Livraison> getAll() {
        return livraisionRepository.findAll();
    }

    public List<Livraison> getLivraisonByChaffeurDisponible(){
        return livraisionRepository.findByChauffeurIsDisponible();
    }

}
