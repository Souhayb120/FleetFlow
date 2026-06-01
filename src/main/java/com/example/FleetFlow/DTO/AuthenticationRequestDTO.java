package com.example.FleetFlow.DTO;

import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    @NonNull
    private String username;
    @NonNull
    @Size(min=6, max=50)
    private String password;
}
