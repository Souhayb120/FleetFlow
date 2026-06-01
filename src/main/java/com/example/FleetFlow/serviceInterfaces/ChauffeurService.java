package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.DTO.CreateChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;

import java.util.List;

public interface ChauffeurService {
    void ajouterChauffeur(CreateChauffeurDTO chauffeur);
    void deleteChauffeur(int id);
    public List<ChauffeurDTO> displayChauffeurs();
    Chauffeur updateChauffeur (int id, Chauffeur newData);
    List<ChauffeurDTO> findByDisponibility();
    List<ChauffeurDTO> findByPermisTypeDisponible(String permisType, Boolean isDisponible);
    List<String> displayChauffeursByNom();

    }

