package com.esalink.dokuman_servisi.service;

import java.util.List;

import com.esalink.dokuman_servisi.model.Client;
import com.esalink.dokuman_servisi.model.Document;

public interface ClientService {
    String getClientById(Document document, Long clientId);

    Client saveClient(Client client);

    List<Client> getAllClients();
}
