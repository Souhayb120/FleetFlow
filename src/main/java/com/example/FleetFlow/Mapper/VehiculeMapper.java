package com.example.FleetFlow.Mapper;
import com.example.FleetFlow.DTO.RequestVehiculeDTO;
import com.example.FleetFlow.DTO.ResponceVehiculeDTO;
import com.example.FleetFlow.models.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
    public interface VehiculeMapper {
            @Mapping(source = "chauffeur.id", target = "chauffeurId")
            ResponceVehiculeDTO toDTO(Vehicule vehicule);
            List<ResponceVehiculeDTO> toDTO(List<Vehicule> vehicules);
            @Mapping(target = "chauffeur", ignore = true)
            Vehicule toEntity(RequestVehiculeDTO vehiculeDTO);
    }
