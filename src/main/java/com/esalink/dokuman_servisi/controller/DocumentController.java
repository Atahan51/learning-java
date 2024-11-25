package com.esalink.dokuman_servisi.controller;

import com.esalink.dokuman_servisi.model.Document;
import com.esalink.dokuman_servisi.service.DocumentService;
import com.esalink.dokuman_servisi.service.ClientService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String listDocuments(Model model, HttpSession session) {
        Long clientId = (Long) session.getAttribute("clientId");
        model.addAttribute("documents", documentService.getAllDocuments(clientId));
        return "document-list";
    }

    @GetMapping("/new")
    public String showNewDocumentForm(Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("clients", clientService.getAllClients());
        return "document-form";
    }

    @PostMapping
    public String saveDocument(@ModelAttribute("document") Document document, HttpSession session) {
        Long id = (Long) session.getAttribute("clientId");
        return clientService.getClientById(document, id);
    }

    @GetMapping("/edit/{id}")
    public String showEditDocumentForm(@PathVariable Long id, Model model) {
        model.addAttribute("document", documentService.getDocumentById(id).orElse(new Document()));
        model.addAttribute("clients", clientService.getAllClients());
        return "document-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return "redirect:/documents";
    }
}
