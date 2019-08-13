package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelAgency")
public class TravelAgencyController {

    private final TravelAgencyServiceImpl travelAgencyServiceImpl;

    @Autowired
    public TravelAgencyController(TravelAgencyServiceImpl travelAgencyServiceImpl) {
        this.travelAgencyServiceImpl = travelAgencyServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("travelAgencies", travelAgencyServiceImpl.list());
        return "travelAgency/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        travelAgencyServiceImpl.delete(id);
        return "redirect:/travelAgency/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("travelAgency", travelAgencyServiceImpl.getById(id));
        return "travelAgency/form";
    }

    @GetMapping("/new")
    public String newTravelAgency(Model model){
        model.addAttribute("travelAgency", new TravelAgency());
        return "travelAgency/form";
    }

    @PostMapping("/save")
    public String save(TravelAgency tourCategory){
        travelAgencyServiceImpl.save(tourCategory);
        return "redirect:/travelAgency/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgency", travelAgencyServiceImpl.getById(id));
        return "travelAgency/card";
    }
}
