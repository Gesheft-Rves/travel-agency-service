package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.service.impl.AppPermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppPermissionController {
    private AppPermissionServiceImpl appPermissionService;

    @Autowired
    public void setAppPermissionService(AppPermissionServiceImpl appPermissionService) {
        this.appPermissionService = appPermissionService;
    }

    @RequestMapping("/apppermissionList")
    public String list(Model model){
        model.addAttribute("apppermissions", appPermissionService.list());
        return "doc/webPages/apppermissionDir/createList";
    }

    @RequestMapping("/apppermissions/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appPermissionService.delete(id);
        return "redirect:/apppermissionList";
    }

    @RequestMapping("/apppermissions/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.read(id));
        return "doc/webPages/apppermissionDir/createForm";
    }

    @RequestMapping("/apppermissions/new")
    public String newAppPermission(Model model){
        model.addAttribute("apppermission", new AppPermission());
        return "doc/webPages/apppermissionDir/createForm";
    }

    @RequestMapping(value = "/apppermissions/save", method = RequestMethod.POST)
    public String save(AppPermission apppermission){
        if(apppermission.getAppPermissionId()== null){
            appPermissionService.create(apppermission);
        } else {
            appPermissionService.update(apppermission);
        }
        return "redirect:/apppermissionList";
    }

    @RequestMapping("/apppermissions/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("apppermission", appPermissionService.read(id));
        return "doc/webPages/apppermissionDir/createCard";
    }
}
