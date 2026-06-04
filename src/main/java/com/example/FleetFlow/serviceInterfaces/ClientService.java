package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;
import com.example.FleetFlow.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService{
    ResponceClientDTO ajouterClient(RequestClientDTO client);
    boolean deleteClient(Long id);
    Page<ResponceClientDTO> afficherClients(Pageable pageable);
    Client updateClient(Long id, Client newData);

}
