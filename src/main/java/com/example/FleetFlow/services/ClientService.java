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
final private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Autowired
    private ClientMapper mapper;

    public void ajouterClient(CreateClientDTO client){
      clientRepository.save(mapper.toEntity(client));
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
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
