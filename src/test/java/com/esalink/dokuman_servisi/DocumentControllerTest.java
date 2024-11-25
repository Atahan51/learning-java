package com.esalink.dokuman_servisi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esalink.dokuman_servisi.controller.DocumentController;
import com.esalink.dokuman_servisi.model.Document;
import com.esalink.dokuman_servisi.model.Client;
import com.esalink.dokuman_servisi.service.ClientServiceImpl;
import com.esalink.dokuman_servisi.service.DocumentService;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class DocumentControllerTest {

    @Mock
    private DocumentService documentService;

    @Mock
    private ClientServiceImpl clientService;

    @InjectMocks
    private DocumentController documentController;

    @Test
    void listDocumentsTest() {

        Document document = new Document();
        Client client = new Client();
        long id = 0;
        Model model = new ExtendedModelMap();

        client.setId(id);
        client.setName("Atahan");

        document.setId(id);
        document.setContent("merhaba");
        document.setTitle("selam");
        document.setClient(client);
        String response = documentController.showEditDocumentForm(id, model);
        assertEquals("document-form", response);

    }
    
    
}