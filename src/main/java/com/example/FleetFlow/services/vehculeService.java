package com.example.FleetFlow.services;

import com.example.FleetFlow.DTO.VehiculeDTO;
import com.example.FleetFlow.Mapper.vehiculeMapper;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.vehculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehculeService {
    @Autowired
    private vehculeRepository vehculeRepository;
    @Autowired
    private vehiculeMapper vehiculeMapper;

    public Vehicule ajouterVehicule(VehiculeDTO  v){
        return vehculeRepository.save(vehiculeMapper.toEntity(v));
    }

    public Vehicule modifierVehicule(Long id , Vehicule v){
        v.setId(id);
        return vehculeRepository.save(v);
    }
public void supprimzeVehicule(Long id){
        vehculeRepository.deleteById(id);
}

public List<Vehicule> findbystatut(String statut){
        return vehculeRepository.findByStatut(statut);
}
public List<Vehicule>findgreteCapacitythan(int capacity){
        return vehculeRepository.findByCapaciteGreaterThan(capacity);
}

}
