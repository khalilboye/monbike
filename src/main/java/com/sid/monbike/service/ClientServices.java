package com.sid.monbike.service;



import com.sid.monbike.dto.ClientDto;
import com.sid.monbike.dto.ClientServiceDto;
import com.sid.monbike.dto.ServiceDto;
import com.sid.monbike.entities.Client;
import com.sid.monbike.entities.ClientServiceAssocPK;
import com.sid.monbike.entities.ClientServiceAssociation;
import com.sid.monbike.entities.Service;
import com.sid.monbike.error.ClientNotFoundException;
import com.sid.monbike.mapper.ClientMapper;
import com.sid.monbike.mapper.ServiceMapper;
import com.sid.monbike.repository.ClientRepository;
import com.sid.monbike.repository.ClientServiceAssociationRepository;
import com.sid.monbike.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientServiceAssociationRepository serviceAssociationRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    public   void associateServiceClient(ClientServiceDto client) {

        Optional<Client> clientById = findClientById(client.getClientView().getId());

        List<Long> idList = client.getServiceViews()
                .stream()
                .map(ServiceDto::getId)
                .collect(Collectors.toList());
        List<Service> serviceList = serviceRepository.findAllById(idList);

        for(Service service : serviceList){
            // List<Service> serviceList = serviceRepository.findAll();
            ClientServiceAssociation assoc = new ClientServiceAssociation();
            ClientServiceAssocPK serviceAssociation = new ClientServiceAssocPK();
            serviceAssociation.setService(service);
            serviceAssociation.setClient(clientById.get());
            assoc.setId(serviceAssociation);
            serviceAssociationRepository.save(assoc);

        }


    }

    public List<ClientDto> findAll() {

        List<Client> clientList = clientRepository.findAll();
        List<ClientDto> clientDtoList = clientMapper.fromClient(clientList);

        return clientDtoList;
    }

    public Client save(ClientDto clientDto) {

        Client client = clientMapper.toClient(clientDto);
        return  clientRepository.save(client);
    }

    public Optional<Client> findClientById(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if(!client.isPresent() ||  client==null ){
           throw new ClientNotFoundException(id);
        }

        return  client;
    }

    public void deleteById(Long id) {
        if(id != null) {
            clientRepository.deleteById(id);
        }
    }

    public ClientDto findClientByTel(String tel) {
        Optional<Client> optionalClient= clientRepository.findClientByTel(tel);
         if(optionalClient==null){
             throw new ClientNotFoundException("Client not found "+optionalClient.get().getId());
         }
        return  clientMapper.getOneClient(optionalClient);
    }

    public Service saveService(ServiceDto serviceDto) {

        Service service = serviceMapper.toService(serviceDto);

        return serviceRepository.save(service);
    }
}
