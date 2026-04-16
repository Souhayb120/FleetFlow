package com.example.FleetFlow.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String email;
    private int age;
    private String phone;
    @OneToMany(mappedBy = "client")
    private List<Livraison> livraisonList;

    public Client(String ayoub, String mail, String number) {
    }
}
