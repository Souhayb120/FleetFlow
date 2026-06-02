package com.example.FleetFlow.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Table(name = "client")
public class Client extends User {
    private int age;
    private String phone;
    @OneToMany(mappedBy = "client")
    private List<Livraison> livraisonList;

}
