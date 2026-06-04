package com.example.FleetFlow.serviceInterfaces;

import com.example.FleetFlow.DTO.RequestVehiculeDTO;
import com.example.FleetFlow.DTO.ResponceVehiculeDTO;
import com.example.FleetFlow.enums.VehiculeStatut;
import com.example.FleetFlow.models.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehculeService {
    ResponceVehiculeDTO ajouterVehicule(RequestVehiculeDTO v);
    ResponceVehiculeDTO modifierVehicule(Long id ,RequestVehiculeDTO v);
    boolean supprimzeVehicule(Long id);
    Page<ResponceVehiculeDTO> findbystatut(VehiculeStatut statut,Pageable pageable);
    Page<ResponceVehiculeDTO> findgreteCapacitythan(int capacity, Pageable pageable);
    Page<ResponceVehiculeDTO> listerVehicule(Pageable pageable);
}
