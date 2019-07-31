package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/approle")
public class AppRoleController {

    private final AppRoleService appRoleService;

    @Autowired
    public AppRoleController(AppRoleService appRoleService) {
        this.appRoleService = appRoleService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("approles", appRoleService.list());
        return "approle/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appRoleService.delete(id);
        return "redirect:/approle/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("approle", appRoleService.getById(id));
        return "approle/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("approle", new AppRole());
        return "approle/form";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("appRole") AppRole appRole){
        appRoleService.save(appRole);
        return "redirect:/approle/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("approle", appRoleService.getById(id));
        return "approle/card";
    }
}
