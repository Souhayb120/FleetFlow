package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.ClientDTO;
import com.example.FleetFlow.DTO.CreateClientDTO;
import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public void saveCommande(@RequestBody CreateClientDTO client){
        clientService.ajouterClient(client);
    }

    @GetMapping
    public List<ClientDTO> displayClients(){
        return clientService.afficherClients();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable  int id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client client){
        return clientService.updateClient(id,client);
    }

}
