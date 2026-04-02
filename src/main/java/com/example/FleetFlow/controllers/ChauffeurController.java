package com.example.FleetFlow.controllers;


import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.services.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @PostMapping
    public void saveChauffeur(@RequestBody Chauffeur chauffeur){
        chauffeurService.ajouterChauffeur(chauffeur);
    }

    @GetMapping
    public List<ChauffeurDTO> displayChaffeur(){
        return chauffeurService.displayChauffeurs();
    }

    @DeleteMapping("/{id}")
    public void deleteChaffeur(@PathVariable  int id){
        chauffeurService.deleteChauffeur(id);
    }

    @PutMapping("/{id}")
    public Chauffeur updateChaffeur(@PathVariable int id,@RequestBody Chauffeur chauffeur){
        return chauffeurService.updateChauffeur(id,chauffeur);
    }

    @GetMapping("/chaffeursDisponible")
    public List<ChauffeurDTO> findByIsDisponible(){
        return chauffeurService.findByDisponibility();
    }


}
