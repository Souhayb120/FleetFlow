package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChauffeurDTO {
    @NotBlank(message = "Name is mandatory")
    private String nom;
    @NotBlank(message = "Phone NUmber is mandatory")
    private String phone;
    @NotBlank(message = "Permis Type is mandatory")
    private String permisType;
    @NotBlank(message = "age Type is mandatory")
    private int age;
}
