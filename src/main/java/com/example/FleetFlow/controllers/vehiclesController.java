package com.example.FleetFlow.controllers;

import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.services.vehculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class vehiclesController {
@Autowired
private vehculeService vehculeService;
@PostMapping
public Vehicule ajouterVehucle(@RequestBody Vehicule v){
return vehculeService.ajouterVehicule(v);
}
@PutMapping("/{id}")
    public Vehicule modefieVehicule(@PathVariable long id , @RequestBody Vehicule v){
    return vehculeService.modifierVehicule(id,v);
}
@DeleteMapping("/{id}")
public void supprimer(@PathVariable long id){
     vehculeService.supprimzeVehicule(id);
}
@GetMapping("/disponiblesVehicules")
public List<Vehicule> vehicules(){
return vehculeService.listerVehicule();
}

@GetMapping("/statut")
public List<Vehicule> findbystatut(boolean statut){
    return vehculeService.findbystatut(statut);
}
@GetMapping("/capacity")
    public List<Vehicule> findGreaterCapacitythan(int capacity){
    return vehculeService.findgreteCapacitythan(capacity);
}

}