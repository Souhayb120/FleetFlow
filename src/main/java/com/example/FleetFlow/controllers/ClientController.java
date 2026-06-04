package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.ResponceClientDTO;
import com.example.FleetFlow.DTO.RequestClientDTO;
import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.services.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }
    @PostMapping("/ajouterClient")
    public ResponseEntity<ResponceClientDTO> saveClient(@Valid @RequestBody RequestClientDTO client) {
        return ResponseEntity.ok(clientServiceImpl.ajouterClient(client));
    }
    @GetMapping("/afficherClients")
    public ResponseEntity<Page<ResponceClientDTO>> displayClients(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "username") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok(clientServiceImpl.afficherClients(PageRequest.of(pageNumber, pageSize, sort)));
    }
    @DeleteMapping("/supprimerClient/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientServiceImpl.deleteClient(id));
    }
    @PutMapping("/modifierClient/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(clientServiceImpl.updateClient(id, client));
    }
}