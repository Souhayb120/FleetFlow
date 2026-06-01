package com.example.FleetFlow.controllers;


import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.DTO.CreateChauffeurDTO;

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

    @PostMapping
    public void saveChauffeur( @Valid @RequestBody CreateChauffeurDTO chauffeur){
        chauffeurServiceImpl.ajouterChauffeur(chauffeur);
    }

    @GetMapping
    public List<ChauffeurDTO> displayChauffeurs(){
        return chauffeurServiceImpl.displayChauffeurs();
    }

    @DeleteMapping("/{id}")
    public void deleteChauffeur(@PathVariable  int id){
        chauffeurServiceImpl.deleteChauffeur(id);
    }

    @PutMapping("/{id}")
    public Chauffeur updateChauffeur(@PathVariable int id,@RequestBody Chauffeur chauffeur){
        return chauffeurServiceImpl.updateChauffeur(id,chauffeur);
    }

    @GetMapping("/chaffeursDisponible")
    public List<ChauffeurDTO> findByIsDisponible(){
        return chauffeurServiceImpl.findByDisponibility();
    }


    @GetMapping("/{permisType}")
    public List<ChauffeurDTO> displayChauffeurs(@PathVariable String permisType ,Boolean isDisponible){
        return chauffeurServiceImpl.findByPermisTypeDisponible(permisType,isDisponible);
    }

    @GetMapping("/displayChauffeurByNom")
    public List<String> displayChauffeursByNom(){
        return chauffeurServiceImpl.displayChauffeursByNom();
    }


}
