package com.esalink.dokuman_servisi.controller;

import com.esalink.dokuman_servisi.model.Client;
import com.esalink.dokuman_servisi.repository.ClientRepository; // ClientRepository import edilmelidir
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {

        Client client = authenticateUser(username, password);

        if (client != null) {
            session.setAttribute("clientId", client.getId());
            return "redirect:/documents";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    public Client authenticateUser(String name, String password) {
        return clientRepository.findByNameAndPassword(name, password);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
