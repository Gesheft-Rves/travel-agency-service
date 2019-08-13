package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.service.impl.TransportSeatServiceImpl;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transportSeat")
public class TransportSeatController {

    private TransportSeatServiceImpl transportSeatServiceImpl;
    private TransportServiceImpl transportServiceImpl;

    @Autowired
    public TransportSeatController(TransportSeatServiceImpl transportSeatServiceImpl, TransportServiceImpl transportServiceImpl) {
        this.transportSeatServiceImpl = transportSeatServiceImpl;
        this.transportServiceImpl = transportServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("transportSeats", transportSeatServiceImpl.list());
        return "transportSeat/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        transportSeatServiceImpl.delete(id);
        return "redirect:/transportSeat/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("transportSeat", transportSeatServiceImpl.getById(id));
        model.addAttribute("transports", transportServiceImpl.list());
        return "transportSeat/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTransportSeat(Model model){
        model.addAttribute("transportSeat", new TransportSeat());
        model.addAttribute("transports", transportServiceImpl.list());
        return "transportSeat/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("transportSeat") TransportSeat transportSeat){
        transportSeatServiceImpl.save(transportSeat);
        return "redirect:/transportSeat/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("transportSeat", transportSeatServiceImpl.getById(id));
        return "transportSeat/card";
    }
}
