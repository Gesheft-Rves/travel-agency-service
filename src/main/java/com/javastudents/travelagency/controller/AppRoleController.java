package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.service.impl.AppRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppRoleController {
    private AppRoleServiceImpl appRoleService;

    @Autowired
    public void setAppRoleService(AppRoleServiceImpl appRoleService) {
        this.appRoleService = appRoleService;
    }

    @RequestMapping("/appRoleList")
    public String list(Model model){
        model.addAttribute("approles", appRoleService.list());
        return "approle/list";
    }

    @RequestMapping("/approles/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appRoleService.delete(id);
        return "redirect:/appRoleList";
    }

    @RequestMapping("/approles/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("approle", appRoleService.read(id));
        return "approle/form";
    }

    @RequestMapping("/approles/new")
    public String newAppPermission(Model model){
        model.addAttribute("approle", new AppRole());
        return "approle/form";
    }

    @RequestMapping(value = "/approles/save", method = RequestMethod.POST)
    public String save(AppRole appRole){
        if(appRole.getAppRoleId()== null){
            appRoleService.create(appRole);
        } else {
            appRoleService.update(appRole);
        }
        return "redirect:/appRoleList";
    }

    @RequestMapping("/approles/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("approle", appRoleService.read(id));
        return "approle/card";
    }
}
