package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChauffeurService {
    ResponceChauffeurDTO ajouterChauffeur(RequestChauffeurDTO chauffeur);
    boolean deleteChauffeur(Long id);
    Page<ResponceChauffeurDTO> displayAllChauffeurs(Pageable pageable);
    Chauffeur updateChauffeur (Long id, Chauffeur newData);
    Page<ResponceChauffeurDTO> findByDisponibility(Pageable pageable);
    Page<ResponceChauffeurDTO> findByPermisTypeDisponible(String permisType, Boolean isDisponible,Pageable pageable);
    Page<ResponceChauffeurDTO> displayChauffeursByNom(String nom,Pageable pageable);

    }

