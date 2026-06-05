    package com.example.FleetFlow.controllers;

    import com.example.FleetFlow.DTO.RequestVehiculeDTO;
    import com.example.FleetFlow.DTO.ResponceVehiculeDTO;
    import com.example.FleetFlow.enums.VehiculeStatut;
    import com.example.FleetFlow.services.VehiculeServiceImpl;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;

    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Sort;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.data.domain.Page;



    @RestController
    @RequestMapping("/api/vehicules")
    @RequiredArgsConstructor
    public class VehiclesController {

    final private VehiculeServiceImpl vehiculeServiceImpl;

    @PostMapping("/ajouterVehicule")
    public ResponseEntity<ResponceVehiculeDTO> ajouterVehucle(@RequestBody @Valid RequestVehiculeDTO v){
    return ResponseEntity.ok(vehiculeServiceImpl.ajouterVehicule(v));
    }

    @PutMapping("/modifierVehicule/{id}")
        public ResponseEntity<ResponceVehiculeDTO> modifierVehicule(@PathVariable Long id, @RequestBody RequestVehiculeDTO dto) {
            return ResponseEntity.ok(vehiculeServiceImpl.modifierVehicule(id,dto));
        }

    @DeleteMapping("/supprimer/{id}")
    public boolean supprimer(@PathVariable long id){
         vehiculeServiceImpl.supprimzeVehicule(id);
         return true;
    }

    @GetMapping("/disponiblesVehicules")
    public ResponseEntity<Page<ResponceVehiculeDTO>>vehicules
            (
                    @RequestParam(defaultValue = "1") int pageNumber,
                    @RequestParam(defaultValue = "5") int pageSize,
                    @RequestParam(defaultValue = "id") String sortBy,
                    @RequestParam(defaultValue = "asc") String sortDer
            )
    {
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Page<ResponceVehiculeDTO> rs = vehiculeServiceImpl.listerVehicule(PageRequest.of(pageNumber,pageSize,sort));
    return ResponseEntity.ok(rs);
    }

    @GetMapping("/findbystatut")
    public ResponseEntity<Page<ResponceVehiculeDTO>> findbystatut(
            @RequestParam VehiculeStatut statut,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ){{
        return  ResponseEntity.ok(vehiculeServiceImpl.findbystatut(statut, PageRequest.of(pageNumber,pageSize)));
    }
    }
    @GetMapping("/findGreaterCapacitythan")
        public ResponseEntity<Page<ResponceVehiculeDTO>>findGreaterCapacitythan(
                @RequestParam int capacity,
                @RequestParam(defaultValue = "1") int pageNumber,
                @RequestParam(defaultValue = "5") int pageSize,
                @RequestParam(defaultValue = "capacite") String sortBy,
                @RequestParam(defaultValue = "asc") String sortDer

    ){
        Sort sort = sortDer.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Page<ResponceVehiculeDTO> rs = vehiculeServiceImpl.findgreteCapacitythan(capacity,PageRequest.of(pageNumber,pageSize,sort));
        return ResponseEntity.ok(rs);
    }
    }