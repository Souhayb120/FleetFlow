package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.models.Livraison;

import java.time.LocalDate;
import java.util.List;

public interface LivraisonService{
    Livraison creeLivraision(Livraison l);
    Livraison assigner(Long livraisonId, Integer chauffeurId, Long vehiculeId);
    Livraison updateStatut(Long id, String statut);
    List<Livraison> getAll();
    List<Livraison> getbystatut(String statut);
    List<Livraison> getLivraisonByChaffeurDisponible();
    List<Livraison> findbyadressedestination(String ville);
    List<Livraison> findbetweendates(LocalDate date1, LocalDate date2);
    List<Livraison> findbyclientId(Long id);

}
