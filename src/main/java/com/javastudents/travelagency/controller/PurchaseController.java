package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.service.impl.PurchaseServiceImpl;
import com.javastudents.travelagency.service.impl.TourScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseServiceImpl purchaseService;
    private TourScheduleServiceImpl tourScheduleService;

    @Autowired
    public PurchaseController(PurchaseServiceImpl purchaseService, TourScheduleServiceImpl tourScheduleService) {
        this.purchaseService = purchaseService;
        this.tourScheduleService = tourScheduleService;
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
        model.addAttribute("purchase", purchaseService.read(id));
        model.addAttribute("tourSchedules", tourScheduleService.list());
        return "purchase/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newAppPermission(Model model){
        model.addAttribute("purchase", new Purchase());
        return "purchase/form";
    }

    @PostMapping("/save")
    public String save(Purchase purchase){
        if(purchase.getPurchaseId()== null){
            purchaseService.create(purchase);
        } else {
            purchaseService.update(purchase);
        }
        return "redirect:/purchase/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("purchase", purchaseService.read(id));
        return "purchase/card";
    }

}
