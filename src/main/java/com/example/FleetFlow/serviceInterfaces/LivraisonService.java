package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.RequestLivraisionDTO;
import com.example.FleetFlow.DTO.ResponceLivraisionDTO;
import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.models.Livraison;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface LivraisonService{
    ResponceLivraisionDTO creeLivraision(RequestLivraisionDTO requestLivraisionDTO);
    ResponceLivraisionDTO assigner(Long livraisonId, Long chauffeurId, Long vehiculeId);
    ResponceLivraisionDTO updateStatut(Long id, LivraisionStatut livraisionStatut);
    Page<Livraison> getAll(Pageable pageable);
    Page<Livraison> getbystatut(LivraisionStatut livraisionStatut, Pageable pageable);
    Page<Livraison> getLivraisonByChauffeurDisponible(Pageable pageable);
    Page<Livraison> findByAdresseDestination(String ville, Pageable pageable);
    Page<Livraison> findBetweenDates(LocalDate date1, LocalDate date2, Pageable pageable);
    Page<Livraison> findByClientId(Long id, Pageable pageable);
}
