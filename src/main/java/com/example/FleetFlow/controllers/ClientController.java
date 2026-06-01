package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;

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

    @PostMapping("/ajouterClient")
    public void saveClient(@Valid @RequestBody RequestClientDTO client){
            clientServiceImpl.ajouterClient(client);
    }

    @GetMapping("/afficherClients")
    public List<ResponceClientDTO> displayClients(){
        return clientServiceImpl.afficherClients();
    }

    @DeleteMapping("/supprimerClient/{id}")
    public void deleteClient(@PathVariable  Long id){
        clientServiceImpl.deleteClient(id);
    }

    @PutMapping("/modifierClient/{id}")
    public Client updateClient(@PathVariable Long id,@RequestBody Client client){
        return clientServiceImpl.updateClient(id,client);
    }

}
