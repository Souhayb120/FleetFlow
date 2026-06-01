package com.example.FleetFlow.services;

import com.example.FleetFlow.DTO.ResponceChauffeurDTO;
import com.example.FleetFlow.Mapper.ChauffeurMapper;
import com.example.FleetFlow.models.Chauffeur;
import com.example.FleetFlow.repositories.ChauffeurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChauffeurServiceImplTest {


    @InjectMocks
    private ChauffeurServiceImpl chauffeurServiceImpl;
    @Mock
    private ChauffeurMapper mapper;
    @Mock
    private ChauffeurRepository chauffeurRepository;

    private ResponceChauffeurDTO responceChauffeurDTO;
    private Chauffeur chauffeur;

    @org.junit.jupiter.api.BeforeEach
    public void setUp(){
        responceChauffeurDTO = new ResponceChauffeurDTO();
        responceChauffeurDTO.setNom("Ali");
        chauffeur = new Chauffeur();
        chauffeur.setNom("Ali");
    }


    @Test
    void findByDisponibility() {
        when(chauffeurRepository.findByIsDisponibleTrue()).thenReturn(List.of(chauffeur));
        when(mapper.toDTO(chauffeur)).thenReturn(responceChauffeurDTO);
        List<ResponceChauffeurDTO> result = chauffeurServiceImpl.findByDisponibility();
        assertNotNull(result);
        verify(chauffeurRepository, times(1)).findByIsDisponibleTrue();
        verify(mapper, times(1)).toDTO(chauffeur);
    }
}