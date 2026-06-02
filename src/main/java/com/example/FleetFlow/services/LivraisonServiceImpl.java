package com.example.FleetFlow.services;

import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.enums.VehiculeStatut;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.LivraisonRepository;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import com.example.FleetFlow.repositories.VehculeRepository;
import com.example.FleetFlow.serviceInterfaces.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    @Autowired
    private LivraisonRepository livraisionRepository;
    @Autowired
    private ChauffeurRepository chauffeurRepository;
    @Autowired
    private VehculeRepository vehiculeRepository;

    public Livraison creeLivraision(Livraison l){
        l.setLivraisionStatut(LivraisionStatut.EN_ATTENTE);
        return livraisionRepository.save(l);
    }
        public Livraison assigner(Long livraisonId, Long chauffeurId, Long vehiculeId) {

            Livraison livraison = livraisionRepository.findById(livraisonId).orElseThrow(() -> new RuntimeException("Not Found"));;
            Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElseThrow(() -> new RuntimeException("Not Found"));
            Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElseThrow(() -> new RuntimeException("Not Found"));
            chauffeur.setIsDisponible(false);
            vehicule.setStatut(VehiculeStatut.EN_SERVICE);
            livraison.setLivraisionStatut(LivraisionStatut.EN_COURS);

            livraison.setChauffeur(chauffeur);
            livraison.setVehicule(vehicule);

            return livraisionRepository.save(livraison);
        }

    public Livraison updateStatut(Long id, LivraisionStatut livraisionStatut) {
        Livraison livraison = livraisionRepository.findById(id).orElseThrow(() -> new RuntimeException("Livraison not found"));
        livraison.setLivraisionStatut(livraisionStatut);
        return livraisionRepository.save(livraison);
    }

    public List<Livraison> getAll() {
        return livraisionRepository.findAll();
    }

    public  List<Livraison> getbystatut(LivraisionStatut livraisionStatut){
        return livraisionRepository.findByLivraisionStatut(livraisionStatut);
    }

    public List<Livraison> findbyclientId(Long id){
        return livraisionRepository.findByClientId(id);
    }
    public List<Livraison> findbetweendates(LocalDate date1,LocalDate date2){
        return livraisionRepository.findBetweenDates(date1,date2);
    }
    public List<Livraison> findbyadressedestination(String ville){
        return livraisionRepository.findByadresseDestination(ville);
    }

    public List<Livraison> getLivraisonByChaffeurDisponible(){
        return livraisionRepository.findByChauffeurIsDisponible();
    }



}
