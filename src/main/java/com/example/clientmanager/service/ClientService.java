package com.example.clientmanager.service;

import com.example.clientmanager.exception.ClientNotFoundException;
import com.example.clientmanager.model.Client;
import com.example.clientmanager.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    public Client findClientById(Long id) {
        return clientRepo.findClientById(id).orElseThrow(() -> new ClientNotFoundException("Client by id " + id + " was not found"));
    }

    public void deleteClient(Long id) {
        clientRepo.deleteClientById(id);
    }
}
