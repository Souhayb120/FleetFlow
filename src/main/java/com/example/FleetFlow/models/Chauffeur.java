package com.example.FleetFlow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "chauffeur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Chauffeur extends User {
    private String phone;
    private String permisType;
    private Boolean isDisponible = true;

    @OneToMany(mappedBy = "chauffeur")
    private List<Livraison> livraisonList;

    @OneToMany(mappedBy = "chauffeur")
    @JsonManagedReference
    private List<Vehicule> vichelList;
}
