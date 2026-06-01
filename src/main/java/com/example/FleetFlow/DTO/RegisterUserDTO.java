package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
    @NonNull
    private String username;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Size(min=6, max=50)
    private String password;
}
