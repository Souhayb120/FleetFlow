package com.example.FleetFlow.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientDTO {
    @NotBlank(message = "Name is mandatory")
    private String nom;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Phone Number is mandatory")
    private String phone;
}
