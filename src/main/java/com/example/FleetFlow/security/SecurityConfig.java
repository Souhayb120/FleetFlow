package com.example.FleetFlow.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static com.example.FleetFlow.enums.Permission.*;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/auth/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html").permitAll()

                        .requestMatchers(HttpMethod.GET,"/api/chauffeurs/**").hasAnyAuthority(ADMIN_READ_CHAUFFEUR.getPermission(),MANAGER_READ_CHAUFFEUR.getPermission())
                        .requestMatchers(HttpMethod.POST,"/api/chauffeurs/**").hasAuthority(ADMIN_CREATE_CHAUFFEUR.getPermission())
                        .requestMatchers(HttpMethod.PUT,"/api/chauffeurs/**").hasAuthority(ADMIN_UPDATE_CHAUFFEUR.getPermission())
                        .requestMatchers(HttpMethod.DELETE,"/api/chauffeurs/**").hasAuthority(ADMIN_DELETE_CHAUFFEUR.getPermission())

                        .requestMatchers(HttpMethod.GET,"/api/clients/**").hasAnyAuthority(ADMIN_READ_CLIENT.getPermission(),MANAGER_READ_CLIENT.getPermission())
                        .requestMatchers(HttpMethod.POST,"/api/clients/**").hasAnyAuthority(ADMIN_CREATE_CLIENT.getPermission(),MANAGER_CREATE_CLIENT.getPermission())
                        .requestMatchers(HttpMethod.PUT,"/api/clients/**").hasAnyAuthority(ADMIN_UPDATE_CLIENT.getPermission(),MANAGER_UPDATE_CLIENT.getPermission())
                        .requestMatchers(HttpMethod.DELETE,"/api/clients/**").hasAnyAuthority(ADMIN_DELETE_CLIENT.getPermission(),MANAGER_DELETE_CLIENT.getPermission())

                        .requestMatchers(HttpMethod.GET,"/api/vehicules/**").hasAnyAuthority(ADMIN_READ_VEHICULE.getPermission(),MANAGER_READ_VEHICULE.getPermission())
                        .requestMatchers(HttpMethod.POST,"/api/vehicules/**").hasAuthority(ADMIN_CREATE_VEHICULE.getPermission())
                        .requestMatchers(HttpMethod.PUT,"/api/vehicules/**").hasAuthority(ADMIN_UPDATE_VEHICULE.getPermission())
                        .requestMatchers(HttpMethod.DELETE,"/api/vehicules/**").hasAuthority(ADMIN_DELETE_VEHICULE.getPermission())

                        .requestMatchers(HttpMethod.GET,"/api/livraison/**").hasAnyAuthority(ADMIN_READ_LIVRAISON.getPermission(),MANAGER_READ_LIVRAISON.getPermission(),CHAUFFEUR_READ_LIVRAISON.getPermission())
                        .requestMatchers(HttpMethod.POST,"/api/livraison/**").hasAnyAuthority(ADMIN_CREATE_LIVRAISON.getPermission(),MANAGER_CREATE_LIVRAISON.getPermission())
                        .requestMatchers(HttpMethod.PUT,"/api/livraison/**").hasAnyAuthority(ADMIN_UPDATE_LIVRAISON.getPermission(),MANAGER_UPDATE_LIVRAISON.getPermission(),CHAUFFEUR_UPDATE_LIVRAISON_STATUS.getPermission())
                        .requestMatchers(HttpMethod.DELETE,"/api/livraison/**").hasAnyAuthority(ADMIN_DELETE_LIVRAISON.getPermission(),MANAGER_DELETE_LIVRAISON.getPermission())

                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
