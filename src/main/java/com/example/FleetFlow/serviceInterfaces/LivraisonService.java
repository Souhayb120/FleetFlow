package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.models.Livraison;

import java.time.LocalDate;
import java.util.List;

public interface LivraisonService{
    Livraison creeLivraision(Livraison l);
    Livraison assigner(Long livraisonId, Long chauffeurId, Long vehiculeId);
    Livraison updateStatut(Long id, LivraisionStatut livraisionStatut);
    List<Livraison> getAll();
    List<Livraison> getbystatut(LivraisionStatut livraisionStatut);
    List<Livraison> getLivraisonByChaffeurDisponible();
    List<Livraison> findbyadressedestination(String ville);
    List<Livraison> findbetweendates(LocalDate date1, LocalDate date2);
    List<Livraison> findbyclientId(Long id);
}
