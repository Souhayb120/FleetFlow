package com.example.FleetFlow.DTO;

import com.example.FleetFlow.enums.VehiculeStatut;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestVehiculeDTO {

    @NotBlank(message = "Matricule is required")
    private String matricule;

    @NotNull(message = "Capacité is required")
    @Min(value = 1, message = "Capacité must be at least 1")
    private int capacite;

    private VehiculeStatut statut;

    @NotBlank(message = "Type is required")
    private String type;

    @NotNull(message = "Chauffeur ID is required")
    private Long chauffeurId;
}