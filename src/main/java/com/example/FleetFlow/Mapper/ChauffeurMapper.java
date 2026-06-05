package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;
import com.example.FleetFlow.models.Chauffeur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ChauffeurMapper {
    @Mapping(target = "username", expression = "java(chauffeur.getRealUsername())")
    ResponceChauffeurDTO toDTO(Chauffeur chauffeur);
    Chauffeur toEntity(RequestChauffeurDTO dto);

}
