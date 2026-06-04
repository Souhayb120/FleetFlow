package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.Chauffeur;
import jakarta.validation.constraints.Email;
import lombok.NonNull;
import org.hibernate.event.internal.PostUpsertEventListenerStandardImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    Page<Chauffeur> findByIsDisponibleTrue(Pageable pageable);
    Page<Chauffeur> findByPermisTypeAndIsDisponible(String permisType, Boolean isDisponible,Pageable pageable);
    Page<Chauffeur> findAll(Pageable pageable);
    Page<Chauffeur> findByNom(String nom, Pageable pageable);
    Optional<Object> findByEmail(String email);
}
