package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.models.Vehicule;
import jakarta.persistence.OneToMany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChaffeurMapper {
        ChauffeurDTO toDTO(Chauffeur chauffeur);
}
