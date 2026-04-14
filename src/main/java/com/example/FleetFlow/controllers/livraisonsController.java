package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.LivraisionDTO;
import com.example.FleetFlow.Mapper.LivraisionMapper;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.services.LivraisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livraison")
public class livraisonsController {

    @Autowired
    private LivraisionService livraisionServices;

    @Autowired
    private LivraisionMapper livraisionMapper;


    @PostMapping
    public LivraisionDTO creatLivraision(@RequestBody LivraisionDTO dto) {

        Livraison livraison = livraisionMapper.toEntity(dto);
        Livraison saved = livraisionServices.creeLivraision(livraison);

        return livraisionMapper.toDTO(saved);
    }


    @PutMapping("/{id}/assign")
    public LivraisionDTO assign(
            @PathVariable long id,
            @RequestParam long chauffeurId,
            @RequestParam long vehiculeId) {

        Livraison livraison = livraisionServices.assigner(id, (int) chauffeurId, vehiculeId);
        return livraisionMapper.toDTO(livraison);
    }


    @PutMapping("/{id}/statut")
    public LivraisionDTO updateStatut(
            @PathVariable Long id,
            @RequestParam String statut) {

        Livraison livraison = livraisionServices.updateStatut(id, statut);
        return livraisionMapper.toDTO(livraison);
    }


    @GetMapping
    public List<LivraisionDTO> list() {

        return livraisionServices.getAll()
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }


    @GetMapping("/getLivraisonByChauffeurDisponible")
    public List<LivraisionDTO> getlivraisonByChauffeurDis() {

        return livraisionServices.getLivraisonByChaffeurDisponible()
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }

    @GetMapping("/statut")
    public List<LivraisionDTO> getbystatut(@RequestParam String statut) {

        return livraisionServices.getbystatut(statut)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }


    @GetMapping("/client")
    public List<LivraisionDTO> findbyclientid(@RequestParam Long id) {

        return livraisionServices.findbyclientId(id)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }


    @GetMapping("/dates")
    public List<LivraisionDTO> findbetweendates(
            @RequestParam LocalDate date1,
            @RequestParam LocalDate date2) {

        return livraisionServices.findbetweendates(date1, date2)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }

    @GetMapping("/destination")
    public List<LivraisionDTO> findbydestinationadress(@RequestParam String ville) {

        return livraisionServices.findbyadressedestination(ville)
                .stream()
                .map(livraisionMapper::toDTO)
                .toList();
    }
}