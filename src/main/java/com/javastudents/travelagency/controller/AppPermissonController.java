package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.service.AppPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/apppermission")
public class AppPermissonController {
    private final AppPermissionService appPermissionService;

    @Autowired
    public AppPermissonController(AppPermissionService appPermissionService) {
        this.appPermissionService = appPermissionService;
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("apppermissions", appPermissionService.list());
        return "apppermission/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appPermissionService.delete(id);
        return "redirect:/apppermission/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.getById(id));
        return "apppermission/form";
    }

    @RequestMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("apppermission", new AppPermission());
        return "apppermission/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(AppPermission apppermission){
            appPermissionService.save(apppermission);
        return "redirect:list";
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.getById(id));
        return "apppermission/card";
    }
}
