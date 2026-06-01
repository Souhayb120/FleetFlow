package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.VehiculeDTO;
import com.example.FleetFlow.models.Vehicule;

import java.util.List;

public interface VehculeService {
    Vehicule ajouterVehicule(VehiculeDTO v);
    Vehicule modifierVehicule(Long id , Vehicule v);
    void supprimzeVehicule(Long id);
    List<Vehicule> findbystatut(String statut);
    List<Vehicule> findgreteCapacitythan(int capacity);
}
