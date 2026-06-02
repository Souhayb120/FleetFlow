    package com.example.FleetFlow.services;

    import com.example.FleetFlow.DTO.ResponceClientDTO;
    import com.example.FleetFlow.DTO.RequestClientDTO;
    import com.example.FleetFlow.Mapper.ClientMapper;
    import com.example.FleetFlow.models.Client;
    import com.example.FleetFlow.repositories.ClientRepository;
    import com.example.FleetFlow.serviceInterfaces.ClientService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class ClientServiceImpl implements ClientService {

        private final ClientRepository clientRepository;
        private final ClientMapper mapper;

        public void ajouterClient(RequestClientDTO client){
            Client newClient = mapper.toEntity(client);
            clientRepository.save(newClient);
        }

        public void deleteClient(Long id){
            Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found with id :"+id));
            clientRepository.delete(client);
        }

            public List<ResponceClientDTO> afficherClients(){
                List<Client> clients = clientRepository.findAll();
                return clients
                        .stream()
                        .map((client)->{
                            ResponceClientDTO dto = mapper.toDTO(client);
                            dto.setNombreLivraison(client.getLivraisonList().size());
                            return dto;
                        })
                        .toList();
                }

        public Client updateClient(Long id, Client newData){
            Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found with id :"+id));
                client.setUsername(newData.getUsername());
                client.setEmail(newData.getEmail());
                client.setPhone(newData.getPhone());
                return clientRepository.save(client);
        }
    }
