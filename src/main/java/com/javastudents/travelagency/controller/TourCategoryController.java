//package com.javastudents.travelagency.controller;
//
//
//import com.javastudents.travelagency.entity.TourCategory;
//import com.javastudents.travelagency.service.impl.TourCategoryServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/tourCategory")
//public class TourCategoryController {
//    private TourCategoryServiceImpl tourCategoryService;
//
//    @Autowired
//    public TourCategoryController(TourCategoryServiceImpl tourCategoryService) {
//        this.tourCategoryService = tourCategoryService;
//    }
//
//    @GetMapping("/list")
//    public String list(Model model){
//        model.addAttribute("tourCategories", tourCategoryService.list());
//        return "tourCategory/list";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id){
//        tourCategoryService.delete(id);
//        return "redirect:/tourCategory/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable  Integer id, Model model){
//        model.addAttribute("tourCategory", tourCategoryService.read(id));
//        return "tourCategory/form";
//    }
//
//    @GetMapping("/new")
//    public String newAppPermission(Model model){
//        model.addAttribute("tourCategory", new TourCategory());
//        return "tourCategory/form";
//    }
//
//    @PostMapping("/save")
//    public String save(TourCategory tourCategory){
//        System.out.println(tourCategory.toString());
//        if(tourCategory.getId()== null){
//            tourCategoryService.create(tourCategory);
//        } else {
//            tourCategoryService.update(tourCategory);
//        }
//        return "redirect:/tourCategory/list";
//    }
//
//    @GetMapping("/details/{id}")
//    public String details(@PathVariable Integer id, Model model){
//        model.addAttribute("tourCategory", tourCategoryService.read(id));
//        return "tourCategory/card";
//    }
//}
