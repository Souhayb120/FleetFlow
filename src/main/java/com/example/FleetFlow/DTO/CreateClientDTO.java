package com.example.FleetFlow.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientDTO {
    private String nom;
    private String email;
    private String phone;
}
