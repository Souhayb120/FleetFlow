package com.example.FleetFlow.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChauffeurDTO {
    private String nom;
    private String phone;
    private String permisType;
}
