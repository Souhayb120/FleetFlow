package com.example.FleetFlow.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponceChauffeurDTO extends ResponseUserDTO {
    private String phone;
    private String permisType;
    private Boolean isDisponible;
    private int nombreLivraisons;
    private int nombreVehicules;
}


