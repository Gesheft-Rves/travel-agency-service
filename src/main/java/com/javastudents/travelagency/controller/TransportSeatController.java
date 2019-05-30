package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.service.TransportSeatService;
import com.javastudents.travelagency.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transportSeat")
public class TransportSeatController {

    private TransportSeatService transportSeatService;
    private TransportService transportService;

    @Autowired
    public TransportSeatController(TransportSeatService transportSeatService, TransportService transportService) {
        this.transportSeatService = transportSeatService;
        this.transportService = transportService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("transportSeats", transportSeatService.list());
        return "transportSeat/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        transportSeatService.delete(id);
        return "redirect:/transportSeat/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("transportSeat", transportSeatService.getById(id));
        model.addAttribute("transports", transportService.list());
        return "transportSeat/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTransportSeat(Model model){
        model.addAttribute("transportSeat", new TransportSeat());
        model.addAttribute("transports", transportService.list());
        return "transportSeat/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("transportSeat") TransportSeat transportSeat){
        transportSeatService.save(transportSeat);
        return "redirect:/transportSeat/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("transportSeat", transportSeatService.getById(id));
        return "transportSeat/card";
    }
}
