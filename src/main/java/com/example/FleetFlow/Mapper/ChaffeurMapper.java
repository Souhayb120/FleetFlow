package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.DTO.CreateChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ChaffeurMapper {
        ChauffeurDTO toDTO(Chauffeur chauffeur);
        Chauffeur toEntity(CreateChauffeurDTO chauffeur);
}
