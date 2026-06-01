package com.example.FleetFlow.controllers;


import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;

import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.services.ChauffeurServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurServiceImpl chauffeurServiceImpl;

    @PostMapping("/ajouterChauffeur")
    public void saveChauffeur( @Valid @RequestBody RequestChauffeurDTO chauffeur){
        chauffeurServiceImpl.ajouterChauffeur(chauffeur);
    }

    @GetMapping("/afficherChauffeurs")
    public List<ResponceChauffeurDTO> displayChauffeurs(){
        return chauffeurServiceImpl.displayChauffeurs();
    }

    @DeleteMapping("/supprimerChauffeur/{id}")
    public void deleteChauffeur(@PathVariable  Long id){
        chauffeurServiceImpl.deleteChauffeur(id);
    }

    @PutMapping("/modifierChauffeur/{id}")
    public Chauffeur updateChauffeur(@PathVariable Long id,@RequestBody Chauffeur chauffeur){
        return chauffeurServiceImpl.updateChauffeur(id,chauffeur);
    }

    @GetMapping("/afficherChaffeursDisponible")
    public List<ResponceChauffeurDTO> findByIsDisponible(){
        return chauffeurServiceImpl.findByDisponibility();
    }

    @GetMapping("/afficherChauffeursByPermis/{permisType}")
    public List<ResponceChauffeurDTO> displayChauffeurs(@PathVariable String permisType , Boolean isDisponible){
        return chauffeurServiceImpl.findByPermisTypeDisponible(permisType,isDisponible);
    }

    @GetMapping("/afficherChauffeurByNom")
    public List<String> displayChauffeursByNom(){
        return chauffeurServiceImpl.displayChauffeursByNom();
    }
}
