package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.entity.dto.PurchaseDTO;
import com.javastudents.travelagency.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final TourScheduleService tourScheduleService;
    private final TravelAgentService travelAgentService;
    private final ClientService clientService;
    private final TransportService transportService;
    private final TransportSeatService transportSeatService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService,
                              TourScheduleService tourScheduleService,
                              TravelAgentService travelAgentService,
                              ClientService clientService,
                              TransportService transportService,
                              TransportSeatService transportSeatService) {
        this.purchaseService = purchaseService;
        this.tourScheduleService = tourScheduleService;
        this.travelAgentService = travelAgentService;
        this.clientService = clientService;
        this.transportService = transportService;
        this.transportSeatService = transportSeatService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("purchases", purchaseService.list());
        return "purchase/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        purchaseService.delete(id);
        return "redirect:/purchase/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("purchase", purchaseService.getById(id));
        model.addAttribute("tourSchedules", tourScheduleService.list());
        model.addAttribute("travelAgents", travelAgentService.list());
        model.addAttribute("clients", clientService.list());
        model.addAttribute("transports", transportService.list());
        model.addAttribute("transportSeats", transportSeatService.list());
        return "purchase/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTour(Model model){
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("tourSchedules", tourScheduleService.list());
        model.addAttribute("travelAgents", travelAgentService.list());
        model.addAttribute("clients", clientService.list());
        model.addAttribute("transports", transportService.list());
        model.addAttribute("transportSeats", transportSeatService.list());
        return "purchase/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("purchase") PurchaseDTO purchaseDTO){
        Purchase purchase = purchaseDtoToPurchase(purchaseDTO);
        purchaseService.save(purchase);
        return "redirect:/purchase/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("purchase", purchaseService.getById(id));
        return "purchase/card";
    }

    private Purchase purchaseDtoToPurchase(PurchaseDTO purchaseDTO){
        return Purchase.builder()
                .id(purchaseDTO.getId())
                .tourSchedule(purchaseDTO.getTourSchedule())
                .travelAgent(purchaseDTO.getTravelAgent())
                .client(purchaseDTO.getClient())
                .transport(purchaseDTO.getTransport())
                .transportSeat(purchaseDTO.getTransportSeat())
                .operationDate(LocalDateTime.parse(purchaseDTO.getOperationDate()))
                .build();
    }
}
