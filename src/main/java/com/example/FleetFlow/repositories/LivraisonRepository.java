package com.example.FleetFlow.repositories;

import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.models.Livraison;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface LivraisonRepository  extends JpaRepository<Livraison,Long>{
    Page<Livraison> findByLivraisionStatut(LivraisionStatut livraisionStatut, Pageable pageable);
    Page<Livraison>findByClientId(long id, Pageable pageable);
    Page<Livraison> findAll(Pageable pageable);

    @Query("SELECT l from Livraison l where l.dateLivraison BETWEEN :date1 AND :date2")
    Page<Livraison> findBetweenDates(LocalDate date1 , LocalDate date2,Pageable pageable);

    @Query("SELECT l from Livraison l where l.adresseDestination LIKE %:ville%")
    Page<Livraison>findByadresseDestination(String ville,Pageable pageable);

    @Query("SELECT l FROM Livraison l JOIN l.chauffeur c WHERE c.isDisponible = true")
    Page<Livraison> findByChauffeurIsDisponible(Pageable pageable);






}
