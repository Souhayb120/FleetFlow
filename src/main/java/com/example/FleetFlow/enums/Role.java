package com.example.FleetFlow.enums;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.FleetFlow.enums.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
            ADMIN_READ_CLIENT, ADMIN_CREATE_CLIENT, ADMIN_UPDATE_CLIENT, ADMIN_DELETE_CLIENT,
            ADMIN_READ_CHAUFFEUR, ADMIN_CREATE_CHAUFFEUR, ADMIN_UPDATE_CHAUFFEUR, ADMIN_DELETE_CHAUFFEUR,
            ADMIN_READ_VEHICULE, ADMIN_CREATE_VEHICULE, ADMIN_UPDATE_VEHICULE, ADMIN_DELETE_VEHICULE,
            ADMIN_READ_LIVRAISON, ADMIN_CREATE_LIVRAISON, ADMIN_UPDATE_LIVRAISON, ADMIN_DELETE_LIVRAISON,
            ADMIN_READ_USER, ADMIN_CREATE_USER, ADMIN_UPDATE_USER, ADMIN_DELETE_USER
            )),
    MANAGER(Set.of(
            MANAGER_READ_CLIENT, MANAGER_CREATE_CLIENT, MANAGER_UPDATE_CLIENT, MANAGER_DELETE_CLIENT,
            MANAGER_READ_LIVRAISON, MANAGER_CREATE_LIVRAISON, MANAGER_UPDATE_LIVRAISON, MANAGER_DELETE_LIVRAISON,
            MANAGER_READ_CHAUFFEUR,
            MANAGER_READ_VEHICULE
    )),
    CHAUFFEUR(Set.of(
            CHAUFFEUR_READ_LIVRAISON,
            CHAUFFEUR_UPDATE_LIVRAISON_STATUS
    ));
@Getter
    private final Set<Permission> permissions;
public List<SimpleGrantedAuthority> getAuthorities(){
    var authereties = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authereties.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
    return authereties;
}
}
