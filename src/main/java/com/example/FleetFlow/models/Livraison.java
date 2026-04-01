package com.example.FleetFlow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "livraison")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    @ToString.Exclude
    @JsonIgnore
    private Chauffeur chauffeur;

}
