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
    Page<ResponceLivraisionDTO> getAll(Pageable pageable);
    Page<ResponceLivraisionDTO> getbystatut(LivraisionStatut livraisionStatut, Pageable pageable);
    Page<ResponceLivraisionDTO> getLivraisonByChauffeurDisponible(Pageable pageable);
    Page<ResponceLivraisionDTO> findByAdresseDestination(String ville, Pageable pageable);
    Page<ResponceLivraisionDTO> findBetweenDates(LocalDate date1, LocalDate date2, Pageable pageable);
    Page<ResponceLivraisionDTO> findByClientId(Long id, Pageable pageable);
}
