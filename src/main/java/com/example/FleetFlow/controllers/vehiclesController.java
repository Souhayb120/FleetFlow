    package com.example.FleetFlow.controllers;

    import com.example.FleetFlow.DTO.VehiculeDTO;
    import com.example.FleetFlow.Mapper.vehiculeMapper;
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
    @Autowired
    private vehiculeMapper vehiculeMapper;
    @PostMapping

    public Vehicule ajouterVehucle(@RequestBody VehiculeDTO v){
    return vehculeService.ajouterVehicule(v);
    }

        @PutMapping("/{id}")
        public VehiculeDTO modifierVehicule(@PathVariable Long id,
                                            @RequestBody VehiculeDTO dto) {
            Vehicule vehicule = vehiculeMapper.toEntity(dto);
            Vehicule updated = vehculeService.modifierVehicule(id, vehicule);
            return vehiculeMapper.toDTO(updated);
        }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable long id){
         vehculeService.supprimzeVehicule(id);
    }
    @GetMapping("/disponiblesVehicules")
    public List<VehiculeDTO> vehicules(){
    return vehculeService.listerVehicule();
    }

    @GetMapping("/statut")
    public List<Vehicule> findbystatut(@RequestParam String statut){
        return vehculeService.findbystatut(statut);
    }

    @GetMapping("/capacity")
        public List<Vehicule> findGreaterCapacitythan(@RequestParam int capacity){
        return vehculeService.findgreteCapacitythan(capacity);
    }
    }