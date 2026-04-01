package com.example.FleetFlow.services;

import com.example.FleetFlow.models.Client;
import com.example.FleetFlow.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
final private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void ajouterClient(Client client){
      clientRepository.save(client);
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }

        public List<Client> afficherClients(){
        return clientRepository.findAll();
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
