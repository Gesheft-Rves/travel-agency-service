package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.service.AppPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/apppermission")
public class AppPermissonController {

    private final AppPermissionService appPermissionService;

    @Autowired
    public AppPermissonController(AppPermissionService appPermissionService) {
        this.appPermissionService = appPermissionService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("apppermissions", appPermissionService.list());
        return "apppermission/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appPermissionService.delete(id);
        return "redirect:/apppermission/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.getById(id));
        return "apppermission/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("apppermission", new AppPermission());
        return "apppermission/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("apppermission") AppPermission apppermission){
            appPermissionService.save(apppermission);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.getById(id));
        return "apppermission/card";
    }
}
