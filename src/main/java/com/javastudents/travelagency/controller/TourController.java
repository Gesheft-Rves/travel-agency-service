package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.service.impl.TourCategoryServiceImpl;
import com.javastudents.travelagency.service.impl.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/tour")
public class TourController {
    private TourServiceImpl tourService;
    private TourCategoryServiceImpl tourCategoryService;

    @Autowired
    public TourController(TourServiceImpl tourService, TourCategoryServiceImpl tourCategoryService) {
        this.tourService = tourService;
        this.tourCategoryService = tourCategoryService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("tours", tourService.list());
        return "tour/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        tourService.delete(id);
        return "redirect:/tour/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("tour", tourService.read(id));
        model.addAttribute("tourCategories", tourCategoryService.list());
        return "tour/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newAppPermission(Model model){
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourCategories", tourCategoryService.list());
        return "tour/form";
    }

    @PostMapping("/save")
    public String save(@PathVariable Tour tour){
        System.out.println(tour.toString());
        if(tour.getTourId()== null){
            tourService.create(tour);
        } else {
            tourService.update(tour);
        }
        return "redirect:/tour/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("tour", tourService.read(id));
        return "tour/card";
    }
}