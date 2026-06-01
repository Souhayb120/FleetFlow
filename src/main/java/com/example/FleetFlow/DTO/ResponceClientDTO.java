package com.example.FleetFlow.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponceClientDTO extends  ResponseUserDTO {
    private int age;
    private String phone;
    private int nombreLivraison;
}
