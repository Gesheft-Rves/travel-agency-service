package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.entity.wrapper.AppRolePermissionWrapper;
import com.javastudents.travelagency.service.AppPermissionService;
import com.javastudents.travelagency.service.AppRolePermissionService;
import com.javastudents.travelagency.service.AppRoleService;
import com.javastudents.travelagency.service.impl.AppPermissionServiceImpl;
import com.javastudents.travelagency.service.impl.AppRolePermissionServiceImpl;
import com.javastudents.travelagency.service.impl.AppRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/approlepermissions")
public class AppRolePermissionController {
    private AppRolePermissionService appRolePermissionService;
    private AppPermissionService appPermissionService;
    private AppRoleService appRoleService;


    @Autowired
    public void setAppRolePermissionService(AppRolePermissionServiceImpl appRolePermissionService) {
        this.appRolePermissionService = appRolePermissionService;
    }

    @Autowired
    public void setAppRoleService(AppRoleServiceImpl appRoleService) {
        this.appRoleService = appRoleService;
    }

    @Autowired
    public void setAppPermissionService(AppPermissionServiceImpl appPermissionService) {
        this.appPermissionService = appPermissionService;
    }


    @RequestMapping("/list")
    public String list(Model model){
        List<AppRolePermissionWrapper> roles = appRolePermissionService.appRolePermissionWrapperList();
        model.addAttribute("approlepermissions", roles);
        return "approlepermissions/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appRolePermissionService.delete(id);
        return "redirect:/approlepermissions/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("permissions",appPermissionService.list());
        model.addAttribute("approlepermission", appRolePermissionService.read(id));
        return "approlepermissions/form";
    }

    @RequestMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("permissions",appPermissionService.list());
        model.addAttribute("approlepermission", new AppRolePermission());
        return "approlepermissions/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(AppRolePermission appRolePermission){
        boolean newRecord = appRolePermission.getAppRolePermissionId()== null;
        if(newRecord){
            appRolePermissionService.create(appRolePermission);
        } else {
            appRolePermissionService.update(appRolePermission);
        }
        return "redirect:list";
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("approlepermission", appRolePermissionService.readAppRolePermissionWrapper(id));
        return "approlepermissions/card";
    }
}

