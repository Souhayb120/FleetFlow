package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ClientDTO;
import com.example.FleetFlow.DTO.CreateClientDTO;
import com.example.FleetFlow.models.Client;

import java.util.List;

public interface ClientService{
    void ajouterClient(CreateClientDTO client);
    void deleteClient(int id);
    List<ClientDTO> afficherClients();
    Client updateClient(int id, Client newData);
}
