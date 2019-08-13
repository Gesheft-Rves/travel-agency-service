package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Client;
import com.javastudents.travelagency.service.impl.ClientServiceImpl;
import com.javastudents.travelagency.service.impl.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private DocumentTypeServiceImpl documentTypeServiceImpl;
    private ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientController(DocumentTypeServiceImpl documentTypeServiceImpl,
                            ClientServiceImpl clientServiceImpl) {
        this.documentTypeServiceImpl = documentTypeServiceImpl;
        this.clientServiceImpl = clientServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("clients",  clientServiceImpl.list());
        return "clients/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        clientServiceImpl.delete(id);
        return "redirect:/clients/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("doctypes", documentTypeServiceImpl.list());
        model.addAttribute("client", clientServiceImpl.getById(id));
        return "clients/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("doctypes", documentTypeServiceImpl.list());
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("client") Client client){
        clientServiceImpl.save(client);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientServiceImpl.getById(id));
        return "clients/card";
    }
}
