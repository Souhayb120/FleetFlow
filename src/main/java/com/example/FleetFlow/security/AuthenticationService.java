package com.example.FleetFlow.security;

import com.example.FleetFlow.DTO.AuthenticationRequestDTO;
import com.example.FleetFlow.DTO.AuthenticationResponceDTO;
import com.example.FleetFlow.DTO.RegisterUserDTO;
import com.example.FleetFlow.Mapper.UserMapper;
import com.example.FleetFlow.enums.Role;
import com.example.FleetFlow.models.User;
import com.example.FleetFlow.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponceDTO register(@Valid RegisterUserDTO registerUserDTO) {

        if(userRepository.findByEmail(registerUserDTO.getEmail()).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user = userMapper.ToEntity(registerUserDTO);

        user.setUsername(registerUserDTO.getUsername());
        user.setEmail(registerUserDTO.getEmail());
        user.setRole(Role.CHAUFFEUR);
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponceDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponceDTO login(AuthenticationRequestDTO request) {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
         User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("email not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponceDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("email not found"));
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().getAuthorities())
                .build();
    }
}
