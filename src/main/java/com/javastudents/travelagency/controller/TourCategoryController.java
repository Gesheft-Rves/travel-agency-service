package com.javastudents.travelagency.controller;


import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.service.TourCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tourCategory")
public class TourCategoryController {
    private TourCategoryService tourCategoryService;

    @Autowired
    public TourCategoryController(TourCategoryService tourCategoryService) {
        this.tourCategoryService = tourCategoryService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("tourCategories", tourCategoryService.list());
        return "tourCategory/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        tourCategoryService.delete(id);
        return "redirect:/tourCategory/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("tourCategory", tourCategoryService.getById(id));
        return "tourCategory/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("tourCategory", new TourCategory());
        return "tourCategory/form";
    }

    @PostMapping("/save")
    public String save(TourCategory tourCategory){
        if(tourCategory.getId()== null){
            tourCategoryService.save(tourCategory);
        } else {
            tourCategoryService.save(tourCategory);
        }
        return "redirect:/tourCategory/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("tourCategory", tourCategoryService.getById(id));
        return "tourCategory/card";
    }
}
