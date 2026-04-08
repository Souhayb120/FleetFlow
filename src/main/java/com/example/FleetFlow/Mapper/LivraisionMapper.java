package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.LivraisionDTO;
import com.example.FleetFlow.models.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivraisionMapper {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    LivraisionDTO toDTO(Livraison livraison);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId", target = "vehicule.id")
    Livraison toEntity(LivraisionDTO dto);
}