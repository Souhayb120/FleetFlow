package com.example.FleetFlow.repositories;

import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChauffeurRepository extends JpaRepository<Chauffeur, Integer> {
    List<Chauffeur> findByIsDisponibleTrue();
    List<ChauffeurDTO> findByPermisTypeAndIsDisponible(String permisType, Boolean isDisponible);


}
