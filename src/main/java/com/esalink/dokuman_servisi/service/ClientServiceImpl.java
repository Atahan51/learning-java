package com.esalink.dokuman_servisi.service;

import com.esalink.dokuman_servisi.model.Client;
import com.esalink.dokuman_servisi.model.Document;
import com.esalink.dokuman_servisi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private DocumentService documentService;

    public Client authenticateUser(String name, String password) {
        return clientRepository.findByNameAndPassword(name, password);
    }

    @Override
    public String getClientById(Document document, Long clientId) {
    
        Optional<Client> selectedClient = clientRepository.findById(clientId);
        
        if (selectedClient.isPresent()) {
            document.setClient(selectedClient.get());
            
            documentService.saveDocument(document);
        } else {
            return "redirect:/error";
        }
    
        return "redirect:/documents";
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
