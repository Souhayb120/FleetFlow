    package com.example.FleetFlow.services;

    import com.example.FleetFlow.DTO.VehiculeDTO;
    import com.example.FleetFlow.Mapper.VehiculeMapper;
    import com.example.FleetFlow.enums.VehiculeStatut;
    import com.example.FleetFlow.models.Vehicule;
    import com.example.FleetFlow.repositories.LivraisonRepository;
    import com.example.FleetFlow.repositories.VehculeRepository;
    import com.example.FleetFlow.serviceInterfaces.VehculeService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class VehiculeServiceImpl implements VehculeService {
        @Autowired
        private VehculeRepository vehculeRepository;
        @Autowired
        private VehiculeMapper vehiculeMapper;
        @Autowired
        private LivraisonRepository livraisionRepository;

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
        public List<VehiculeDTO> listerVehicule() {
            List<Vehicule> vehicules = vehculeRepository.findAll();
            return vehiculeMapper.toDTO(vehicules);
        }

    public List<Vehicule> findbystatut(VehiculeStatut statut){
            return vehculeRepository.findByStatut(statut);
    }
    public List<Vehicule>findgreteCapacitythan(int capacity){
            return vehculeRepository.findByCapaciteGreaterThan(capacity);
    }

    }
