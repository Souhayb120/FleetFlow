package com.example.FleetFlow.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String nom;
    private String email;
    private int age;
    private String phone;
    private int nombreLivraison;
}
