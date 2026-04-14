package com.example.FleetFlow.services;
import com.example.FleetFlow.Mapper.vehiculeMapper;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.vehculeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)


public class VehculeServiceTest {

@Mock
private vehculeRepository vehculeRepository;
@Mock
private vehiculeMapper vehiculeMapper ;
    @Test
    void listerVehiculeTest() {
        List<Vehicule> vehiculeList= List.of(new Vehicule());
    }
    @Test
    void findgreteCapacitythanTest() {
    }
    @InjectMocks
    private VehculeService vehculeService;

}
