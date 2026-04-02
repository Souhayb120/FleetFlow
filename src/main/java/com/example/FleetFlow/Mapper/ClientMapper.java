package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ClientDTO;
import com.example.FleetFlow.models.Client;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ClientMapper {
        ClientDTO toDTO(Client client);
}
