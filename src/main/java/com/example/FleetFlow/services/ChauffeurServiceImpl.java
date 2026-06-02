package com.example.FleetFlow.services;


import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.DTO.RequestChauffeurDTO;
import com.example.FleetFlow.Mapper.ChauffeurMapper;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import com.example.FleetFlow.serviceInterfaces.ChauffeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChauffeurServiceImpl implements ChauffeurService {
    private final ChauffeurMapper mapper;
    private final ChauffeurRepository chauffeurRepository;

    public void ajouterChauffeur(RequestChauffeurDTO chauffeur){
        chauffeurRepository.save(mapper.toEntity(chauffeur));
    }

    public void deleteChauffeur(Long id){
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElseThrow(()-> new RuntimeException("Chauffeur not found with id :"+id));
        chauffeurRepository.delete(chauffeur);
    }

    public List<ResponceChauffeurDTO> displayChauffeurs(){
       List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ResponceChauffeurDTO dto = mapper.toDTO(chauffeur);
                    dto.setNombreVehicules(chauffeur.getVichelList().size());
                    dto.setNombreLivraisons(chauffeur.getLivraisonList().size());
                    return dto;
                })
                .toList();
    }

    public Chauffeur updateChauffeur (Long id, Chauffeur newData){
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElseThrow(()-> new RuntimeException("Chauffeur not found with id :"+id));
            chauffeur.setUsername(newData.getUsername());
            chauffeur.setPhone(newData.getPhone());
            chauffeur.setIsDisponible(newData.getIsDisponible());
            chauffeur.setPermisType(newData.getPermisType());
            return chauffeurRepository.save(chauffeur);
    }

    public List<ResponceChauffeurDTO> findByDisponibility(){
        List<Chauffeur> chauffeurs = chauffeurRepository.findByIsDisponibleTrue();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ResponceChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto;
                }).toList();
    }

    public List<ResponceChauffeurDTO> findByPermisTypeDisponible(String permisType, Boolean isDisponible){
        List<Chauffeur> chauffeurs = chauffeurRepository.findByPermisTypeAndIsDisponible(permisType,isDisponible);
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ResponceChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto;
                }).toList();
    }
    public List<String> displayChauffeursByNom(){
        List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ResponceChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto.getUsername();
                }).toList();
    }
}