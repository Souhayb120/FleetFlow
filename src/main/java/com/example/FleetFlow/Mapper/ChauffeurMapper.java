package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ChauffeurMapper {
        ResponceChauffeurDTO toDTO(Chauffeur chauffeur);
        Chauffeur toEntity(RequestChauffeurDTO dto);

}
