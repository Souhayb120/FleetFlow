package com.example.FleetFlow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String matricule;
    private int capacite;
    private String statut ;
    private String type;


    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    @JsonBackReference
    private Chauffeur chauffeur;



}
