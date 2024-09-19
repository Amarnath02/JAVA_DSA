package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"", "/"})
    public String getClients(Model model) {
        var clients = clientRepository.findAll();
        model.addAttribute("clients", clients);

        return "clients/index";
    }

    @GetMapping("create")
    public String createClient(Model model) {
        ClientDetails clientDetails = new ClientDetails();
        model.addAttribute("clientDetails", clientDetails);

        return "clients/create";
    }

    @PostMapping("create")
    public String createClient(@Valid @ModelAttribute ClientDetails clientDetails ,
                               BindingResult result) {

        if (clientRepository.findByEmail(clientDetails.getEmail()) != null) {
            result.addError(new FieldError("clientDetails", "email", clientDetails.getEmail(),
                    false, null, null, "Email address is already used"));
        }

        if (result.hasErrors()) {
            return "clients/create";
        }

        Client client = new Client();

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setAddress(clientDetails.getAddress());
        client.setStatus(clientDetails.getStatus());
        client.setCreatedAt(new Date());

        clientRepository.save(client);

        return "redirect:/clients";
    }

    @GetMapping("/edit")
    public String showEditClients(Model model, @RequestParam int id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            return "redirect:/clients";
        }

        ClientDetails clientDetails = new ClientDetails();

        clientDetails.setFirstName(client.getFirstName());
        clientDetails.setLastName(client.getLastName());
        clientDetails.setEmail(client.getEmail());
        clientDetails.setPhone(client.getPhone());
        clientDetails.setAddress(client.getAddress());
        clientDetails.setStatus(client.getStatus());

        model.addAttribute("client", client);
        model.addAttribute("clientDetails", clientDetails);

        return "clients/edit";
    }

    @PostMapping("/edit")
    public String updateClient(Model model, @RequestParam int id,
                               @Valid @ModelAttribute ClientDetails clientDetails,
                               BindingResult result) {

        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            return "redirect:/clients";
        }
        model.addAttribute("client", client);

        if (result.hasErrors()) {
            return "clients/edit";
        }

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setAddress(clientDetails.getAddress());
        client.setStatus(clientDetails.getStatus());

        try {
            clientRepository.save(client);
        }
        catch (Exception e) {
            result.addError(new FieldError("clientDetails", "email", clientDetails.getEmail(),
                    false, null, null, "Email address is already used"));

            return "clients/edit";
        }

        return "redirect:/clients";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam int id) {
        try {
            Client client = clientRepository.findById(id).orElse(null);

            if (client == null) {
                return "redirect:/clients";
            }
            clientRepository.delete(client);
        }
        catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return "redirect:/clients";
    }
}
