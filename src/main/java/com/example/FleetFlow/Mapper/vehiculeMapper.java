package com.example.FleetFlow.Mapper;
import com.example.FleetFlow.DTO.VehiculeDTO;
import com.example.FleetFlow.models.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

    @Mapper(componentModel = "spring")
    public interface vehiculeMapper {

            @Mapping(source = "chauffeur.id", target = "chauffeurId")
            VehiculeDTO toDTO(Vehicule vehicule);

            @Mapping(source = "chauffeurId", target = "chauffeur.id")
            Vehicule toEntity(VehiculeDTO vehiculeDTO);
    }
