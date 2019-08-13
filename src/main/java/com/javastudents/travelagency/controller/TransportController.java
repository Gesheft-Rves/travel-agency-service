package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transport")
public class TransportController {

    private final TransportServiceImpl transportServiceImpl;

    @Autowired
    public TransportController(TransportServiceImpl transportServiceImpl) {
        this.transportServiceImpl = transportServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("transports", transportServiceImpl.list());
        return "transport/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        transportServiceImpl.delete(id);
        return "redirect:/transport/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("transport", transportServiceImpl.getById(id));
        return "transport/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTransport(Model model) {
        model.addAttribute("transport", new Transport());
        return "transport/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("transport") Transport transport) {
        transportServiceImpl.save(transport);
        return "redirect:/transport/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model) {
        model.addAttribute("transport", transportServiceImpl.getById(id));
        return "transport/card";
    }
}
