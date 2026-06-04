package com.example.FleetFlow.controllers;


import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;

import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.services.ChauffeurServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<ResponceChauffeurDTO>> displayChauffeurs(
            @RequestParam (defaultValue = "1") int pageNumber,
            @RequestParam (defaultValue = "5") int pagrSize,
            @RequestParam (defaultValue = "username") String sortBY,
            @RequestParam (defaultValue = "asc") String  sortDer
    ){
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();
      Page<ResponceChauffeurDTO> rs = chauffeurServiceImpl.displayAllChauffeurs(PageRequest.of(pageNumber,pagrSize,sort));
        return ResponseEntity.ok(rs);
    }

    @DeleteMapping("/supprimerChauffeur/{id}")
    public boolean deleteChauffeur(@PathVariable  Long id){
        chauffeurServiceImpl.deleteChauffeur(id);
        return true;
    }

    @PutMapping("/modifierChauffeur/{id}")
    public Chauffeur updateChauffeur(@PathVariable Long id,@RequestBody Chauffeur chauffeur){
        return chauffeurServiceImpl.updateChauffeur(id,chauffeur);
    }

    @GetMapping("/afficherChaffeursDisponible")
    public ResponseEntity<Page<ResponceChauffeurDTO>> findByIsDisponible(
            @RequestParam (defaultValue = "1") int pageNumber,
            @RequestParam (defaultValue = "5") int pagrSize,
            @RequestParam (defaultValue = "username") String sortBY,
            @RequestParam (defaultValue = "asc") String  sortDer
    )
    {
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();
        Page<ResponceChauffeurDTO> rs = chauffeurServiceImpl.findByDisponibility(PageRequest.of(pageNumber,pagrSize,sort));
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/afficherChauffeursByPermis/{permisType}")
    public ResponseEntity<Page<ResponceChauffeurDTO>> displayChauffeurs(
            @RequestParam (defaultValue = "1") int pageNumber,
            @RequestParam (defaultValue = "5") int pagrSize,
            @RequestParam (defaultValue = "username") String sortBY,
            @RequestParam (defaultValue = "asc") String  sortDer,
            @RequestParam String permisType ,
            @RequestParam Boolean isDisponible
    )
    {
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();
        Page<ResponceChauffeurDTO> rs = chauffeurServiceImpl.findByPermisTypeDisponible(permisType,isDisponible,PageRequest.of(pageNumber,pagrSize,sort));
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/afficherChauffeurByNom")
    public ResponseEntity<Page<ResponceChauffeurDTO>> displayChauffeursByNom
            (       @RequestParam String nom,
                    @RequestParam (defaultValue = "1") int pageNumber,
                    @RequestParam (defaultValue = "5") int pagrSize,
                    @RequestParam (defaultValue = "username") String sortBY,
                    @RequestParam (defaultValue = "asc") String  sortDer
            ){
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBY).ascending() : Sort.by(sortBY).descending();
        Page<ResponceChauffeurDTO> rs = chauffeurServiceImpl.displayChauffeursByNom(nom,PageRequest.of(pageNumber,pagrSize,sort));
        return ResponseEntity.ok(rs);
    }
}
