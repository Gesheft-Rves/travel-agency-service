package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.service.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseServiceImpl purchaseService;

    @Autowired
    public PurchaseController(PurchaseServiceImpl purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("purchases", purchaseService.list());
        return "doc/webPages/purchaseDir/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        purchaseService.delete(id);
        return "redirect:doc/webPages/purchaseDir/list";
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("purchase", purchaseService.read(id));
        return "doc/webPages/purchaseDir/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newAppPermission(Model model){
        model.addAttribute("purchase", new Purchase());
        return "doc/webPages/purchaseDir/createForm";
    }

    @PostMapping("/save")
    public String save(Purchase purchase){
        if(purchase.getPurchaseId()== null){
            purchaseService.create(purchase);
        } else {
            purchaseService.update(purchase);
        }
        return "redirect:doc/webPages/purchaseDir/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("purchase", purchaseService.read(id));
        return "doc/webPages/purchaseDir/card";
    }

}
