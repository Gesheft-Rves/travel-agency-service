package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.entity.dto.PurchaseDTO;
import com.javastudents.travelagency.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseServiceImpl purchaseServiceImpl;
    private final TourScheduleServiceImpl tourScheduleServiceImpl;
    private final TravelAgentServiceImpl travelAgentServiceImpl;
    private final ClientServiceImpl clientServiceImpl;
    private final TransportServiceImpl transportServiceImpl;
    private final TransportSeatServiceImpl transportSeatServiceImpl;

    @Autowired
    public PurchaseController(PurchaseServiceImpl purchaseServiceImpl,
                              TourScheduleServiceImpl tourScheduleServiceImpl,
                              TravelAgentServiceImpl travelAgentServiceImpl,
                              ClientServiceImpl clientServiceImpl,
                              TransportServiceImpl transportServiceImpl,
                              TransportSeatServiceImpl transportSeatServiceImpl) {
        this.purchaseServiceImpl = purchaseServiceImpl;
        this.tourScheduleServiceImpl = tourScheduleServiceImpl;
        this.travelAgentServiceImpl = travelAgentServiceImpl;
        this.clientServiceImpl = clientServiceImpl;
        this.transportServiceImpl = transportServiceImpl;
        this.transportSeatServiceImpl = transportSeatServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("purchases", purchaseServiceImpl.list());
        return "purchase/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        purchaseServiceImpl.delete(id);
        return "redirect:/purchase/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("purchase", purchaseServiceImpl.getById(id));
        model.addAttribute("tourSchedules", tourScheduleServiceImpl.list());
        model.addAttribute("travelAgents", travelAgentServiceImpl.list());
        model.addAttribute("clients", clientServiceImpl.list());
        model.addAttribute("transports", transportServiceImpl.list());
        model.addAttribute("transportSeats", transportSeatServiceImpl.list());
        return "purchase/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTour(Model model){
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("tourSchedules", tourScheduleServiceImpl.list());
        model.addAttribute("travelAgents", travelAgentServiceImpl.list());
        model.addAttribute("clients", clientServiceImpl.list());
        model.addAttribute("transports", transportServiceImpl.list());
        model.addAttribute("transportSeats", transportSeatServiceImpl.list());
        return "purchase/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("purchase") PurchaseDTO purchaseDTO){
        Purchase purchase = purchaseDtoToPurchase(purchaseDTO);
        purchaseServiceImpl.save(purchase);
        return "redirect:/purchase/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("purchase", purchaseServiceImpl.getById(id));
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
