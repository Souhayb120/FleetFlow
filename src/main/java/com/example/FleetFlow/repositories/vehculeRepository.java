package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface vehculeRepository extends JpaRepository<Vehicule,Long> {
List<Vehicule> findByDisponibleIsTrue();
}
