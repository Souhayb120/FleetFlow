package com.example.FleetFlow.repositories;

import com.example.FleetFlow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean findClientByEmail(String email);
    boolean existsByEmail(String email);
}
