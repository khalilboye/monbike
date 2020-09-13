package com.sid.monbike.mapper;


import com.sid.monbike.dto.ClientDto;
import com.sid.monbike.entities.Client;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientMapper {
    public Client toClient(ClientDto clientDto){

        Client client = new Client();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(clientDto.getAdresse());
        client.setTel(clientDto.getTel());
        client.setEmail(clientDto.getEmail());

        return client ;

    }

    public List<ClientDto> fromClient(List<Client> clients){

        List<ClientDto> clientDtos = new ArrayList<>();
        for(Client client : clients){

            ClientDto clientDto = new ClientDto();
            clientDto.setId(client.getId());
            clientDto.setNom(client.getNom());
            clientDto.setPrenom(client.getPrenom());
            clientDto.setAdresse(client.getAdresse());
            clientDto.setTel(client.getTel());
            clientDto.setEmail(client.getEmail());

            clientDtos.add(clientDto);
        }

        return clientDtos ;

    }

    public ClientDto getOneClient(Optional<Client> client){

        ClientDto clientDto = new ClientDto();
        clientDto.setNom(client.get().getNom());
        clientDto.setPrenom(client.get().getPrenom());
        clientDto.setAdresse(client.get().getAdresse());
        clientDto.setTel(client.get().getTel());
        clientDto.setEmail(client.get().getEmail());

        return clientDto ;

    }
}
