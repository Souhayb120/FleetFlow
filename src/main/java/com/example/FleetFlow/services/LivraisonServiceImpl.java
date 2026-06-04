package com.example.FleetFlow.services;

import com.example.FleetFlow.DTO.RequestLivraisionDTO;
import com.example.FleetFlow.DTO.ResponceLivraisionDTO;
import com.example.FleetFlow.Mapper.LivraisionMapper;
import com.example.FleetFlow.enums.LivraisionStatut;
import com.example.FleetFlow.enums.VehiculeStatut;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.models.Vehicule;
import com.example.FleetFlow.repositories.ClientRepository;
import com.example.FleetFlow.repositories.LivraisonRepository;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import com.example.FleetFlow.repositories.VehculeRepository;
import com.example.FleetFlow.serviceInterfaces.LivraisonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class LivraisonServiceImpl implements LivraisonService {
   final private LivraisonRepository livraisionRepository;
   final private ChauffeurRepository chauffeurRepository;
   final private VehculeRepository vehiculeRepository;
   final private LivraisionMapper livraisionMapper;
    private final ClientRepository clientRepository;


    public ResponceLivraisionDTO creeLivraision(RequestLivraisionDTO requestLivraisionDTO){
        Livraison livraison = livraisionMapper.toEntity(requestLivraisionDTO);
        livraison.setLivraisionStatut(LivraisionStatut.EN_ATTENTE);

        livraison.setClient(clientRepository.findById(requestLivraisionDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found")));
        livraison.setChauffeur(chauffeurRepository.findById(requestLivraisionDTO.getChauffeurId())
                .orElseThrow(() -> new RuntimeException("Chauffeur not found")));
        livraison.setVehicule(vehiculeRepository.findById(requestLivraisionDTO.getVehiculeId())
                .orElseThrow(() -> new RuntimeException("Véhicule not found")));

        return livraisionMapper.toDTO(livraisionRepository.save(livraison));

    }


        public ResponceLivraisionDTO  assigner(Long livraisonId, Long chauffeurId, Long vehiculeId) {
            Livraison livraison = livraisionRepository.findById(livraisonId).orElseThrow(() -> new RuntimeException("Not Found"));;
            Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElseThrow(() -> new RuntimeException("Not Found"));
            Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElseThrow(() -> new RuntimeException("Not Found"));
            chauffeur.setIsDisponible(false);
            vehicule.setStatut(VehiculeStatut.EN_SERVICE);
            livraison.setLivraisionStatut(LivraisionStatut.EN_COURS);

            livraison.setChauffeur(chauffeur);
            livraison.setVehicule(vehicule);

            return livraisionMapper.toDTO(livraisionRepository.save(livraison));
        }

    public ResponceLivraisionDTO updateStatut(Long id, LivraisionStatut livraisionStatut) {
        Livraison livraison = livraisionRepository.findById(id).orElseThrow(() -> new RuntimeException("Livraison not found"));
        livraison.setLivraisionStatut(livraisionStatut);
        return livraisionMapper.toDTO(livraisionRepository.save(livraison));
    }
    @Override
    public Page<Livraison> getAll(Pageable pageable) {
        return livraisionRepository.findAll(pageable);
    }
    @Override
    public Page<Livraison> getbystatut(LivraisionStatut livraisionStatut, Pageable pageable){
        return livraisionRepository.findByLivraisionStatut(livraisionStatut,pageable);
    }
    @Override
    public Page<Livraison> findByClientId(Long id, Pageable pageable) {
        return livraisionRepository.findByClientId(id, pageable);
    }
    @Override
    public Page<Livraison> findBetweenDates(LocalDate date1, LocalDate date2, Pageable pageable) {
        return livraisionRepository.findBetweenDates(date1, date2, pageable);
    }
    @Override
    public Page<Livraison> findByAdresseDestination(String ville, Pageable pageable) {
        return livraisionRepository.findByadresseDestination(ville, pageable);
    }
    @Override
    public Page<Livraison> getLivraisonByChauffeurDisponible(Pageable pageable) {
        return livraisionRepository.findByChauffeurIsDisponible(pageable);
    }


}
