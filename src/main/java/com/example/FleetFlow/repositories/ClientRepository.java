package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {}