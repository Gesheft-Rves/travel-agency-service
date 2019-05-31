package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Client;
import com.javastudents.travelagency.service.ClientService;
import com.javastudents.travelagency.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private DocumentTypeService documentTypeService;
    private ClientService clientService;

    @Autowired
    public ClientController(DocumentTypeService documentTypeService, ClientService clientService) {
        this.documentTypeService = documentTypeService;
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("clients",  clientService.list());
        return "clients/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        clientService.delete(id);
        return "redirect:/clients/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("doctypes",documentTypeService.list());
        model.addAttribute("client", clientService.getById(id));
        return "clients/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("doctypes",documentTypeService.list());
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("client") Client client){
        clientService.save(client);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientService.getById(id));
        return "clients/card";
    }
}
