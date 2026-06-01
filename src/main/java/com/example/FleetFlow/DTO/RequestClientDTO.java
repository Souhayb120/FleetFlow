package com.example.FleetFlow.DTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestClientDTO extends  RegisterUserDTO {
    @NonNull
    private int age;
    @NotBlank(message = "Phone Number is mandatory")
    private String phone;
}
