package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;

import java.util.List;

public interface ChauffeurService {
    void ajouterChauffeur(RequestChauffeurDTO chauffeur);
    void deleteChauffeur(Long id);
    public List<ResponceChauffeurDTO> displayChauffeurs();
    Chauffeur updateChauffeur (Long id, Chauffeur newData);
    List<ResponceChauffeurDTO> findByDisponibility();
    List<ResponceChauffeurDTO> findByPermisTypeDisponible(String permisType, Boolean isDisponible);
    List<String> displayChauffeursByNom();

    }

