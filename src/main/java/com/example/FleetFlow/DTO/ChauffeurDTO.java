package com.example.FleetFlow.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChauffeurDTO {
    private String nom;
    private String phone;
    private String permisType;
    private Boolean isDisponible;
    private int nombreLivraisons;
    private int nombreVehicules;
}


