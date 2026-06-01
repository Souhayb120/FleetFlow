package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;
import com.example.FleetFlow.models.Client;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ClientMapper  {
        ResponceClientDTO toDTO(Client client);
        Client toEntity(RequestClientDTO client);
}
