package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LivraisonRepository  extends JpaRepository<Livraison,Long>{
    List<Livraison>findByStatut(String statut);

    List<Livraison>findByClientId(long id);

    @Query("SELECT l from Livraison l where l.dateLivraison BETWEEN :date1 AND :date2")
    List<Livraison> findBetweenDates(LocalDate date1 , LocalDate date2);

    @Query("SELECT l from Livraison l where l.adresseDestination LIKE %:ville%")
    List<Livraison>findByadresseDestination(String ville);

    @Query("SELECT l FROM Livraison l JOIN l.chauffeur c WHERE c.isDisponible = true")
    List<Livraison> findByChauffeurIsDisponible();






}
