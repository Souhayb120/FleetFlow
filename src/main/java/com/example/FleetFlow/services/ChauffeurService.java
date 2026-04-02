package com.example.FleetFlow.services;


import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurService {
    final private ChauffeurRepository chauffeurRepository;

    public ChauffeurService(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }

    public void ajouterChauffeur(Chauffeur chauffeur){
        chauffeurRepository.save(chauffeur);
    }

    public void deleteChauffeur(int id){
        chauffeurRepository.deleteById(id);
    }

    public List<Chauffeur> displayChauffeurs(){
      return  chauffeurRepository.findAll();
    }

    public Chauffeur updateChauffeur (int id, Chauffeur newData){
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElse(null);
        if(chauffeur != null){
            chauffeur.setNom(newData.getNom());
            chauffeur.setPhone(newData.getPhone());
            chauffeur.setIsDisponible(newData.getIsDisponible());
            chauffeur.setPermisType(newData.getPermisType());
            return chauffeurRepository.save(chauffeur);
        }
        return null;
    }

    public List<Chauffeur> findByDisponibility(){
     return chauffeurRepository.findByIsDisponibleTrue();
    }

}
