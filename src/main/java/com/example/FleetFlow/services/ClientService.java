package com.example.FleetFlow.services;

import com.example.FleetFlow.DTO.ClientDTO;
import com.example.FleetFlow.DTO.CreateClientDTO;
import com.example.FleetFlow.Mapper.ClientMapper;
import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    public ClientService(ClientRepository clientRepository, ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    public void ajouterClient(CreateClientDTO client){
        if(!clientRepository.existsByEmail(client.getEmail())){
            clientRepository.save(mapper.toEntity(client));
        }
    }

    public void deleteClient(int id){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
        }

    }

        public List<ClientDTO> afficherClients(){
            List<Client> clients = clientRepository.findAll();
            return clients
                    .stream()
                    .map((client)->{
                        ClientDTO dto = mapper.toDTO(client);
                        dto.setNombreLivraison(client.getLivraisonList().size());
                        return dto;
                    })
                    .toList();
            }

    public Client updateClient(int id, Client newData){
        Client client = clientRepository.findById(id).orElse(null);
        if(client != null){
            client.setNom(newData.getNom());
            client.setEmail(newData.getEmail());
            client.setPhone(newData.getPhone());
            return clientRepository.save(client);
        }
        return null;
    }


}
