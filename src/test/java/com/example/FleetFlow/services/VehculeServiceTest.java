package com.example.FleetFlow.services;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.VehculeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)


public class VehculeServiceTest {
    @InjectMocks
    private VehculeService vehculeService;
    @Mock
    private VehculeRepository vehculeRepository;
    @Test
    void shouldReturnVehiculesByStatut() {
        String statut = "Disponible";
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setStatut(statut);
        Vehicule vehicule2 = new Vehicule();
        vehicule2.setStatut(statut);

        List<Vehicule> vehicules = List.of(vehicule1,vehicule2);

      when(vehculeRepository.findByStatut(statut)).thenReturn(vehicules);

      List<Vehicule> rs = vehculeService.findbystatut(statut);

        assertTrue(
              rs.stream()
                      .allMatch(v -> v.getStatut().equals(statut))
      );

    }
    @Test
    void shouldReturnVehiculesWithCapacityGreaterThan() {
        //GIVEN
        int capacity = 50;
        Vehicule vehicule1= new Vehicule();
        vehicule1.setCapacite(60);
        Vehicule vehicule2 = new Vehicule();
        vehicule2.setCapacite(80);

        List<Vehicule> vehicules = List.of(vehicule1,vehicule2);

        when(vehculeRepository.findByCapaciteGreaterThan(capacity)).thenReturn(vehicules);
        //WHEN
        List<Vehicule> rs = vehculeService.findgreteCapacitythan(capacity);

        //THEN
        assertTrue(
                rs.stream()
                .allMatch(v -> v.getCapacite() > capacity));
    }


}
