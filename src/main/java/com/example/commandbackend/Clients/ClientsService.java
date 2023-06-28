package com.example.commandbackend.Clients;

import com.example.commandbackend.Clients.Dtos.ClientDto;
import com.example.commandbackend.Clients.Dtos.CreateClientDto;
import com.example.commandbackend.Clients.Entities.Clients;
import com.example.commandbackend.Orders.Entities.Orders;
import com.example.commandbackend.ProductCategory.Entities.ProductCategory;
import com.example.commandbackend.Products.Entities.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private EntityManager entityManager;

    public ClientDto create(CreateClientDto clientInfo){
        Clients newClient = new Clients();
        newClient.setName(clientInfo.name);
        newClient.setDocument(clientInfo.document);

        clientsRepository.save(newClient);

        ClientDto clientRes = new ClientDto(
                newClient.getId(),
                newClient.getName(),
                newClient.getDocument(),
                newClient.isHasTicket()
        );

        return clientRes;
    }

    public ClientDto getById(Long id){
        Clients client = clientsRepository.findById(id).get();
        ClientDto clientRes = new ClientDto(
                client.getId(),
                client.getName(),
                client.getDocument(),
                client.isHasTicket()
        );

        return clientRes;
    }

    public ClientDto getByDocument(String document){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Clients> query = cb.createQuery(Clients.class);
        Root<Clients> client = query.from(Clients.class);

        query.where(cb.equal(client.get("document"), document));

        query.select(client);

        Clients clientFound = entityManager.createQuery(query).getSingleResult();

        ClientDto clientRes = new ClientDto(
                clientFound.getId(),
                clientFound.getName(),
                clientFound.getDocument(),
                clientFound.isHasTicket()
        );

        return clientRes;
    }


    public List<Clients> getAll(){
        return clientsRepository.findAll();
    }

    public void delete(Long id){
        Clients client = clientsRepository.findById(id).get();
        clientsRepository.delete(client);
    }
}
