package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestChauffeurDTO extends RegisterUserDTO{
    @NotBlank(message = "Phone Number is mandatory")
    private String phone;
    @NotBlank(message = "Permis Type is mandatory")
    private String permisType;
    @NonNull
    private int age;
}
