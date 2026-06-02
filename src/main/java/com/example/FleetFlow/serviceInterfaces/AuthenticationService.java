package com.example.FleetFlow.serviceInterfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails loadUserByUsername(String username);
}
