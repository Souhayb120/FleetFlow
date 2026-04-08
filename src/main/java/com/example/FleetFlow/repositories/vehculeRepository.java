package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface vehculeRepository extends JpaRepository<Vehicule,Long> {
List<Vehicule> findBystatut(String statut);
@Query("SELECT v FROM Vehicule v where v.capacite > :thisCapcity")
    List<Vehicule> findByCapaciteGreaterThan(int capacity);

}
