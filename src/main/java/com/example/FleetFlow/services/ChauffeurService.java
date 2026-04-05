package com.example.FleetFlow.services;


import com.example.FleetFlow.DTO.ChauffeurDTO;
import com.example.FleetFlow.DTO.CreateChauffeurDTO;
import com.example.FleetFlow.Mapper.ChauffeurMapper;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurService {

    @Autowired
    private ChauffeurMapper mapper;
    @Autowired
    private ChauffeurRepository chauffeurRepository;



    public ChauffeurService(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }

    public void ajouterChauffeur(CreateChauffeurDTO chauffeur){
        chauffeurRepository.save(mapper.toEntity(chauffeur));
    }

    public void deleteChauffeur(int id){
        chauffeurRepository.deleteById(id);
    }

    public List<ChauffeurDTO> displayChauffeurs(){
       List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ChauffeurDTO dto = mapper.toDTO(chauffeur);
                    dto.setNombreVehicules(chauffeur.getVichelList().size());
                    dto.setNombreLivraisons(chauffeur.getLivraisonList().size());
                    return dto;
                })
                .toList();
    }

    public Chauffeur updateChauffeur (int id, Chauffeur newData){
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElse(null);
        if(chauffeur != null){
            chauffeur.setNom(newData.getNom());
            chauffeur.setPhone(newData.getPhone());
            chauffeur.setIsDisponible(newData.getIsDisponible());
            chauffeur.setPermisType(newData.getPermisType());
            return chauffeurRepository.save(chauffeur);
        }
        return null;
    }

    public List<ChauffeurDTO> findByDisponibility(){
        List<Chauffeur> chauffeurs = chauffeurRepository.findByIsDisponibleTrue();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto;
                }).toList();
    }


    public List<ChauffeurDTO> findByPermisTypeDisponible(String permisType,Boolean isDisponible){
        List<Chauffeur> chauffeurs = chauffeurRepository.findByPermisTypeAndIsDisponible(permisType,isDisponible);
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto;
                }).toList();
    }


    public List<String> displayChauffeursByNom(){
        List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs
                .stream()
                .map((chauffeur)->{
                    ChauffeurDTO dto = mapper.toDTO(chauffeur);
                    return dto.getNom();
                }).toList();
    }
}
