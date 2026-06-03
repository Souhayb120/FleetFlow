package com.example.FleetFlow.enums;

import lombok.*;


@Getter
@RequiredArgsConstructor
public enum Permission {

    // ─── ADMIN ────

    ADMIN_READ_CLIENT("admin:client:read"),
    ADMIN_CREATE_CLIENT("admin:client:create"),
    ADMIN_UPDATE_CLIENT("admin:client:update"),
    ADMIN_DELETE_CLIENT("admin:client:delete"),

    ADMIN_READ_CHAUFFEUR("admin:chauffeur:read"),
    ADMIN_CREATE_CHAUFFEUR("admin:chauffeur:create"),
    ADMIN_UPDATE_CHAUFFEUR("admin:chauffeur:update"),
    ADMIN_DELETE_CHAUFFEUR("admin:chauffeur:delete"),

    ADMIN_READ_VEHICULE("admin:vehicule:read"),
    ADMIN_CREATE_VEHICULE("admin:vehicule:create"),
    ADMIN_UPDATE_VEHICULE("admin:vehicule:update"),
    ADMIN_DELETE_VEHICULE("admin:vehicule:delete"),

    ADMIN_READ_LIVRAISON("admin:livraison:read"),
    ADMIN_CREATE_LIVRAISON("admin:livraison:create"),
    ADMIN_UPDATE_LIVRAISON("admin:livraison:update"),
    ADMIN_DELETE_LIVRAISON("admin:livraison:delete"),

    ADMIN_READ_USER("admin:user:read"),
    ADMIN_CREATE_USER("admin:user:create"),
    ADMIN_UPDATE_USER("admin:user:update"),
    ADMIN_DELETE_USER("admin:user:delete"),


    // ─── MANAGER ───────
    MANAGER_READ_CLIENT("manager:client:read"),
    MANAGER_CREATE_CLIENT("manager:client:create"),
    MANAGER_UPDATE_CLIENT("manager:client:update"),
    MANAGER_DELETE_CLIENT("manager:client:delete"),

    MANAGER_READ_LIVRAISON("manager:livraison:read"),
    MANAGER_CREATE_LIVRAISON("manager:livraison:create"),
    MANAGER_UPDATE_LIVRAISON("manager:livraison:update"),
    MANAGER_DELETE_LIVRAISON("manager:livraison:delete"),

    MANAGER_READ_CHAUFFEUR("manager:chauffeur:read"),

    MANAGER_READ_VEHICULE("manager:vehicule:read"),


    // ─── CHAUFFEUR ────────

    CHAUFFEUR_READ_LIVRAISON("chauffeur:livraison:read"),
    CHAUFFEUR_UPDATE_LIVRAISON_STATUS("chauffeur:livraison:update_status"),
    ;

    private final String permission;
}

