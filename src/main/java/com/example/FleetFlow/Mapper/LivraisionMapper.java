package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.RequestLivraisionDTO;
import com.example.FleetFlow.DTO.ResponceLivraisionDTO;
import com.example.FleetFlow.models.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivraisionMapper {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    ResponceLivraisionDTO toDTO(Livraison livraison);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "chauffeur", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    Livraison toEntity(RequestLivraisionDTO dto);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId", target = "vehicule.id")
    Livraison toEntity(ResponceLivraisionDTO dto);




}