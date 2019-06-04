package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppUserRole;
import com.javastudents.travelagency.service.AppRoleService;
import com.javastudents.travelagency.service.AppUserRoleService;
import com.javastudents.travelagency.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appuserrole")
public class AppUserRoleController {
    private AppUserRoleService appUserRoleService;
    private AppUserService appUserService;
    private AppRoleService appRoleService;

    @Autowired
    public AppUserRoleController(AppUserRoleService appUserRoleService,
                                 AppUserService appUserService,
                                 AppRoleService appRoleService) {
        this.appUserRoleService = appUserRoleService;
        this.appUserService = appUserService;
        this.appRoleService = appRoleService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<AppUserRole> roles = appUserRoleService.list();
        model.addAttribute("appuserroles", roles);
        return "appuserrole/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appUserRoleService.delete(id);
        return "redirect:/appuserrole/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("users", appUserService.list());
        model.addAttribute("appuserrole", appUserRoleService.getById(id));
        return "appuserrole/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("roles",appRoleService.list());
        model.addAttribute("users", appUserService.list());
        model.addAttribute("appuserrole", new AppUserRole());
        return "appuserrole/form";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("appUserRole") AppUserRole appUserRole){
        appUserRoleService.save(appUserRole);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("appuserrole", appUserRoleService.getById(id));
        return "appuserrole/card";
    }
}
