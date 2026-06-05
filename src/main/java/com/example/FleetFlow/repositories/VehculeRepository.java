package com.example.FleetFlow.repositories;

import com.example.FleetFlow.enums.VehiculeStatut;
import com.example.FleetFlow.models.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface VehculeRepository extends JpaRepository<Vehicule,Long> {
Page<Vehicule> findByStatut(VehiculeStatut statut, Pageable pageable);
Page<Vehicule> findAll(Pageable pageable);

@Query("SELECT v FROM Vehicule v where v.capacite > :thisCapcity")
    Page<Vehicule> findByCapaciteGreaterThan(int thisCapcity, Pageable pageable);

}