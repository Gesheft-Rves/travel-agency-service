//package com.javastudents.travelagency.controller;
//
//import com.javastudents.travelagency.entity.TravelAgency;
//import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/travelAgency")
//public class TravelAgencyController {
//
//    private TravelAgencyServiceImpl travelAgencyService;
//
//    @Autowired
//    public TravelAgencyController(TravelAgencyServiceImpl travelAgencyService) {
//        this.travelAgencyService = travelAgencyService;
//    }
//
//    @GetMapping("/list")
//    public String list(Model model){
//        model.addAttribute("travelAgencies", travelAgencyService.list());
//        return "travelAgency/list";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id){
//        travelAgencyService.delete(id);
//        return "redirect:/travelAgency/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable  Integer id, Model model){
//        model.addAttribute("travelAgency", travelAgencyService.read(id));
//        return "travelAgency/form";
//    }
//
//    @GetMapping("/new")
//    public String newAppPermission(Model model){
//        model.addAttribute("travelAgency", new TravelAgency());
//        return "travelAgency/form";
//    }
//
//    @PostMapping("/save")
//    public String save(TravelAgency tourCategory){
//        System.out.println(tourCategory.toString());
//        if(tourCategory.getId()== null){
//            travelAgencyService.create(tourCategory);
//        } else {
//            travelAgencyService.update(tourCategory);
//        }
//        return "redirect:/travelAgency/list";
//    }
//
//    @GetMapping("/details/{id}")
//    public String details(@PathVariable Integer id, Model model){
//        model.addAttribute("travelAgency", travelAgencyService.read(id));
//        return "travelAgency/card";
//    }
//}
