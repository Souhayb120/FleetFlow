package com.example.FleetFlow.Mapper;
import com.example.FleetFlow.DTO.VehiculeDTO;
import com.example.FleetFlow.models.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
    public interface vehiculeMapper {
            @Mapping(source = "chauffeur.id", target = "chauffeurId")
            VehiculeDTO toDTO(Vehicule vehicule);
            List<VehiculeDTO> toDTO(List<Vehicule> vehicules);
            @Mapping(source = "chauffeurId", target = "chauffeur.id")
            Vehicule toEntity(VehiculeDTO vehiculeDTO);
    }
