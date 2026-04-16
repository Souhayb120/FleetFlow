package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientByNom(String nom);

    boolean findClientByEmail(String email);


    boolean existsByEmail(String email);
}