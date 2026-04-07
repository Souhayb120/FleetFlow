package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivraisionDTO {
        private Long id;

        @NotNull
        private LocalDate dateLivraison;

        @NotBlank
        private String adresseDepart;

        @NotBlank
        private String adresseDestination;

        @NotBlank
        private String statut;

        @NotNull
        private Long clientId;

        @NotNull
        private Long chauffeurId;

        @NotNull
        private Long vehiculeId;
}
