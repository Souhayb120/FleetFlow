package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.ClientDTO;
import com.example.FleetFlow.DTO.CreateClientDTO;

import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.services.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @PostMapping
    public void saveClient(@Valid @RequestBody CreateClientDTO client){
            clientServiceImpl.ajouterClient(client);
    }

    @GetMapping
    public List<ClientDTO> displayClients(){
        return clientServiceImpl.afficherClients();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable  int id){
        clientServiceImpl.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client client){
        return clientServiceImpl.updateClient(id,client);
    }

}
