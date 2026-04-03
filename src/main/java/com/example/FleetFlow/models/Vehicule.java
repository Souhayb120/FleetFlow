package com.example.FleetFlow.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vehicule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String matrecule;
    private int capacite;
    private String status;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    @ToString.Exclude
    @JsonIgnore
    private Chauffeur chauffeur;
}
