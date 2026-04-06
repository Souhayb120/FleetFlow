package com.example.FleetFlow.controllers;

import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.services.livraisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livraison")
public class livraisonsController {
    @Autowired
    private livraisionService livraisionServices;
 @PostMapping
    public Livraison creatLivraision(@RequestBody Livraison livraison){
     return livraisionServices.creeLivraision(livraison);
 }
@PutMapping("/{id}/assign")
    public Livraison assign(
            @PathVariable long id,
            @RequestParam long chauffeurId,
            @RequestParam long vehiculeId){
     return livraisionServices.assigner(id, (int) chauffeurId,vehiculeId);
}

    @PutMapping("/{id}/statut")
    public Livraison updateStatut(
            @PathVariable Long id,
            @RequestParam String statut) {

        return livraisionServices.updateStatut(id, statut);
    }
    @GetMapping
    public List<Livraison> list() {
        return livraisionServices.getAll();
    }


    @GetMapping("/getLivraisonByChauffeurDisponible")
    public List<Livraison> getlivraisonByChauffeurDis() {
        return livraisionServices.getLivraisonByChaffeurDisponible();
    }
    @GetMapping("/statut")
    public List<Livraison> getbystatut( @RequestParam String statut){
     return livraisionServices.getbystatut(statut);
    }
    @GetMapping("/client")
    public List<Livraison> findbyclientid( @RequestParam Long id){
     return livraisionServices.findbyclientId(id);
    }
    @GetMapping("/dates")
    public List<Livraison>findbetweendates( @RequestParam LocalDate date1, @RequestParam LocalDate date2){
     return livraisionServices.findbetweendates(date1,date2);
    }
    @GetMapping("/destination")
    public List<Livraison>findbydestinationadress( @RequestParam String ville){
        return livraisionServices.findbyadressedestination(ville);
    }
}
