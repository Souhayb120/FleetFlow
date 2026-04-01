package com.example.FleetFlow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "chauffeur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String phone;
    private String permisType;
    private String status;

    @OneToMany(mappedBy = "chauffeur")
    private List<Livraison> livraisonList;

    @OneToMany(mappedBy = "chauffeur")
    private List<Vehicule> vichelList;

}
