package com.example.FleetFlow.services;

import com.example.FleetFlow.models.Livraison;
import com.example.FleetFlow.repositories.LivraisonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LivraisionServiceTest {
    @InjectMocks
    private LivraisionService livraisionService;
    @Mock
    private LivraisonRepository livraisonRepository;
    @Test
    void shouldCreateLivraisonWithInitialStatus(){

        Livraison livraison = new Livraison();

        livraisionService.creeLivraision(livraison);

        assertEquals("EN_ATTENTE",livraison.getStatut());;
    }
}
