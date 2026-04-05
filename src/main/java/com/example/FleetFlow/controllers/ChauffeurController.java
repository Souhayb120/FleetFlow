package com.example.FleetFlow.controllers;


import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.DTO.CreateChauffeurDTO;
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
    public void saveChauffeur(@RequestBody CreateChauffeurDTO chauffeur){
        chauffeurService.ajouterChauffeur(chauffeur);
    }

    @GetMapping
    public List<ChauffeurDTO> displayChauffeurs(){
        return chauffeurService.displayChauffeurs();
    }

    @DeleteMapping("/{id}")
    public void deleteChauffeur(@PathVariable  int id){
        chauffeurService.deleteChauffeur(id);
    }

    @PutMapping("/{id}")
    public Chauffeur updateChauffeur(@PathVariable int id,@RequestBody Chauffeur chauffeur){
        return chauffeurService.updateChauffeur(id,chauffeur);
    }

    @GetMapping("/chaffeursDisponible")
    public List<ChauffeurDTO> findByIsDisponible(){
        return chauffeurService.findByDisponibility();
    }


    @GetMapping("/{permisType}")
    public List<ChauffeurDTO> displayChauffeurs(@PathVariable String permisType ,Boolean isDisponible){
        return chauffeurService.findByPermisTypeDisponible(permisType,isDisponible);
    }

    @GetMapping("/displayChauffeurByNom")
    public List<String> displayChauffeursByNom(){
        return chauffeurService.displayChauffeursByNom();
    }


}
