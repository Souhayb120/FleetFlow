    package com.example.FleetFlow.services;

    import com.example.FleetFlow.DTO.ResponceClientDTO;
    import com.example.FleetFlow.DTO.RequestClientDTO;
    import com.example.FleetFlow.Mapper.ClientMapper;
    import com.example.FleetFlow.models.Client;
    import com.example.FleetFlow.repositories.ClientRepository;
    import com.example.FleetFlow.repositories.UserRepository;
    import com.example.FleetFlow.serviceInterfaces.ClientService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class ClientServiceImpl implements ClientService {

        private final ClientRepository clientRepository;
        private final ClientMapper mapper;
        private final UserRepository userRepository;

        public void ajouterClient(RequestClientDTO client){
            if(!userRepository.existsByEmail(client.getEmail())){
                userRepository.save(mapper.toEntity(client));
            }
        }

        public void deleteClient(Long id){
            if(clientRepository.existsById(id)){
                clientRepository.deleteById(id);
            }
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
            Client client = clientRepository.findById(id).orElse(null);
            if(client != null){
                client.setUsername(newData.getUsername());
                client.setEmail(newData.getEmail());
                client.setPhone(newData.getPhone());
                return clientRepository.save(client);
            }
            return null;
        }


    }
