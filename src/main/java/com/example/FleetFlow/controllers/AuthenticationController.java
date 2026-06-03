package com.example.FleetFlow.controllers;

import com.example.FleetFlow.DTO.AuthenticationRequestDTO;
import com.example.FleetFlow.DTO.AuthenticationResponceDTO;
import com.example.FleetFlow.DTO.RegisterUserDTO;
import com.example.FleetFlow.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService ;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponceDTO> register(
            @Valid @RequestBody RegisterUserDTO registerUserDTO){
        return ResponseEntity.ok(authenticationService.register(registerUserDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponceDTO> login(
            @Valid @RequestBody AuthenticationRequestDTO authenticationRequestDTO){
        return ResponseEntity.ok(authenticationService.login(authenticationRequestDTO));
    }

}
