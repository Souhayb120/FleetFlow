package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDTO {
        @NotBlank
        private String matricule;
        @Positive
        private int capacite;
        private String statut;
        @NotBlank
        private String type;
        @NotNull
        private Long chauffeurId;
}
