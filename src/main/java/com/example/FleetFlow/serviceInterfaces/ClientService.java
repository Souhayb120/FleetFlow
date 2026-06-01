package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;
import com.example.FleetFlow.models.Client;

import java.util.List;

public interface ClientService{
    void ajouterClient(RequestClientDTO client);
    void deleteClient(Long id);
    List<ResponceClientDTO> afficherClients();
    Client updateClient(Long id, Client newData);
}
