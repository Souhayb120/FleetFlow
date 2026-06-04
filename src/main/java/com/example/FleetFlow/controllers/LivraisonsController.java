package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.ResponceLivraisionDTO;
import com.example.FleetFlow.Mapper.LivraisionMapper;
import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.services.LivraisonServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livraison")
public class LivraisonsController {
    @Autowired
    private LivraisonServiceImpl livraisonServicesImpl;
    @Autowired
    private LivraisionMapper livraisionMapper;

    @PostMapping("/creerLivraison")
    public ResponceLivraisionDTO creatLivraision(@RequestBody @Valid ResponceLivraisionDTO dto) {
        Livraison livraison = livraisionMapper.toEntity(dto);
        Livraison saved = livraisonServicesImpl.creeLivraision(livraison);
        return livraisionMapper.toDTO(saved);
    }

    @PutMapping("/{id}/assign")
    public ResponceLivraisionDTO assign(
            @PathVariable long id,
            @RequestParam long chauffeurId,
            @RequestParam long vehiculeId) {
        Livraison livraison = livraisonServicesImpl.assigner(id, (Long) chauffeurId, vehiculeId);
        return livraisionMapper.toDTO(livraison);
    }

    @PutMapping("/{id}/statut")
    public ResponceLivraisionDTO updateStatut(
            @PathVariable Long id,
            @RequestParam LivraisionStatut statut) {
        Livraison livraison = livraisonServicesImpl.updateStatut(id, statut);
        return livraisionMapper.toDTO(livraison);
    }

    @GetMapping("/AfficherLivraison")
    public ResponseEntity<Page<ResponceLivraisionDTO>> getlivraision(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(livraisonServicesImpl.getAll((Pageable) PageRequest.of(pageNumber, pageSize, sort))
                .map(livraisionMapper::toDTO));
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
        return ResponseEntity.ok(livraisonServicesImpl.getLivraisonByChauffeurDisponible((Pageable) PageRequest.of(pageNumber-1, pageSize, sort))
                .map(livraisionMapper::toDTO));
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
            Page<ResponceLivraisionDTO> rs = livraisonServicesImpl.getbystatut(statut,(Pageable) PageRequest.of(pageNumber-1,pageSize,sort));
            return ResponseEntity.ok(rs);
    }

    @GetMapping("/AfficherLivraisonByClient")
    public List<ResponceLivraisionDTO> findbyclientid(@RequestParam Long id) {
        return livraisonServicesImpl.findbyclientId(id)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }


    @GetMapping("/AfficherLivraisonBetweenDates")
    public List<ResponceLivraisionDTO> findbetweendates(
            @RequestParam LocalDate date1,
            @RequestParam LocalDate date2) {
        return livraisonServicesImpl.findbetweendates(date1, date2)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }

    @GetMapping("/AfficherLivraisonByDestination")
    public List<ResponceLivraisionDTO> findbydestinationadress(@RequestParam String ville) {
        return livraisonServicesImpl.findbyadressedestination(ville)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }
}