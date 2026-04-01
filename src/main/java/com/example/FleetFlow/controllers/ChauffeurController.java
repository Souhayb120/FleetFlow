package com.example.FleetFlow.controllers;


import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.services.ChauffeurService;
import com.example.FleetFlow.services.ClientService;
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
    public List<Chauffeur> displayChaffeur(){
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

    @GetMapping
    public List<Chauffeur> findByStatus(String status){
        return chauffeurService.findByStatus(status);
    }


}
