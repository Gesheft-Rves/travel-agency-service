package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.service.AppPermissionService;
import com.javastudents.travelagency.service.AppRolePermissionService;
import com.javastudents.travelagency.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/approlepermissions")
public class AppRolePermissionController {

    private final AppRolePermissionService appRolePermissionService;
    private final AppPermissionService appPermissionService;
    private final AppRoleService appRoleService;


    @Autowired
    public AppRolePermissionController(AppRolePermissionService appRolePermissionService,
                                       AppRoleService appRoleService,
                                       AppPermissionService appPermissionService) {
        this.appRolePermissionService = appRolePermissionService;
        this.appRoleService = appRoleService;
        this.appPermissionService = appPermissionService;
    }



    @GetMapping("/list")
    public String list(Model model){
        List<AppRolePermission> roles = appRolePermissionService.list();
        model.addAttribute("approlepermissions", roles);
        return "approlepermissions/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appRolePermissionService.delete(id);
        return "redirect:/approlepermissions/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("permissions",appPermissionService.list());
        model.addAttribute("approlepermission", appRolePermissionService.getById(id));
        return "approlepermissions/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("permissions",appPermissionService.list());
        model.addAttribute("approlepermission", new AppRolePermission());
        return "approlepermissions/form";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("appRolePermission") AppRolePermission appRolePermission){
        appRolePermissionService.save(appRolePermission);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("approlepermission", appRolePermissionService.getById(id));
        return "approlepermissions/card";
    }
}

