package com.example.FleetFlow.controllers;

import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.services.livraisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
