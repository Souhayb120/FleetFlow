package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.RequestLivraisionDTO;
import com.example.FleetFlow.DTO.ResponceLivraisionDTO;
import com.example.FleetFlow.Mapper.LivraisionMapper;
import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.services.LivraisonServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/livraison")
public class LivraisonsController {
    final private LivraisonServiceImpl livraisonServicesImpl;

    @PostMapping("/creerLivraison")
    public ResponseEntity<ResponceLivraisionDTO>  creatLivraision(@RequestBody @Valid RequestLivraisionDTO dto) {
        return ResponseEntity.ok(livraisonServicesImpl.creeLivraision(dto));
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<ResponceLivraisionDTO>  assign(
            @PathVariable long id,
            @RequestParam long chauffeurId,
            @RequestParam long vehiculeId) {
        return ResponseEntity.ok(livraisonServicesImpl.assigner(id,chauffeurId,vehiculeId));
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<ResponceLivraisionDTO>  updateStatut(
            @PathVariable Long id,
            @RequestParam LivraisionStatut statut) {
        return ResponseEntity.ok(livraisonServicesImpl.updateStatut(id,statut));
    }

    @GetMapping("/AfficherLivraison")
    public ResponseEntity<Page<ResponceLivraisionDTO>> getlivraision(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(livraisonServicesImpl.getAll(PageRequest.of(pageNumber, pageSize, sort)));
    }

    @GetMapping("/AfficherLivraisonByChauffeurDisponible")
    public ResponseEntity<Page<ResponceLivraisionDTO>>getlivraisonByChauffeurDis
            (
                    @RequestParam(defaultValue = "1") int pageNumber,
                    @RequestParam(defaultValue = "5") int pageSize,
                    @RequestParam(defaultValue = "id") String sortBy,
                    @RequestParam(defaultValue = "asc") String sortDir
            )
    {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok
                (livraisonServicesImpl.getLivraisonByChauffeurDisponible(PageRequest.of(pageNumber-1, pageSize, sort)));
    }

    @GetMapping("/AfficherLivraisonByStatut")
    public ResponseEntity<Page<ResponceLivraisionDTO>>getbystatut(
            @RequestParam LivraisionStatut statut,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir

    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            Page<ResponceLivraisionDTO> rs = livraisonServicesImpl.getbystatut(statut,PageRequest.of(pageNumber-1,pageSize,sort));
            return ResponseEntity.ok(rs);
    }

    @GetMapping("/AfficherLivraisonByClient")
    public ResponseEntity<Page<ResponceLivraisionDTO>> findbyclientid(
            @RequestParam Long id,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir

    ) {
        Sort sort= sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(livraisonServicesImpl.findByClientId(id,PageRequest.of(pageNumber-1,pageSize,sort)));
    }


    @GetMapping("/AfficherLivraisonBetweenDates")
    public ResponseEntity<Page<ResponceLivraisionDTO>>  findbetweendates(
            @RequestParam LocalDate date1,
            @RequestParam LocalDate date2,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort= sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(livraisonServicesImpl.findBetweenDates(date1,date2,PageRequest.of(pageNumber-1,pageSize,sort)));
    }

    @GetMapping("/AfficherLivraisonByDestination")
    public ResponseEntity<Page<ResponceLivraisionDTO>> findbydestinationadress
            (@RequestParam String ville,
             @RequestParam(defaultValue = "1") int pageNumber,
             @RequestParam(defaultValue = "5") int pageSize,
             @RequestParam(defaultValue = "id") String sortBy,
             @RequestParam(defaultValue = "asc") String sortDir

            ) {
        Sort sort= sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(livraisonServicesImpl.findByAdresseDestination(ville,PageRequest.of(pageNumber-1,pageSize,sort)));
    }
}