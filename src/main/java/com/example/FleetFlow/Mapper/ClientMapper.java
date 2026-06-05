package com.example.FleetFlow.Mapper;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;
import com.example.FleetFlow.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper  {
    @Mapping(target = "username", expression = "java(client.getRealUsername())")
    ResponceClientDTO toDTO(Client client);
    Client toEntity(RequestClientDTO dto);

}
