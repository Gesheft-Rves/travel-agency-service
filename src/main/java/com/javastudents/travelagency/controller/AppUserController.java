package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.AppUser;
import com.javastudents.travelagency.service.AppUserService;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/appusers")
public class AppUserController {
    private AppUserService appUserService;
    private TravelAgentService travelAgentService;

    @Autowired
    public void setAppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Autowired
    public void setTravelAgentService(TravelAgentService travelAgentService) {
        this.travelAgentService = travelAgentService;
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<AppUser> users = appUserService.list();
        model.addAttribute("appusers", users);
        return "appusers/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        appUserService.delete(id);
        return "redirect:/appusers/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("agents",travelAgentService.list());
        model.addAttribute("appuser", appUserService.getById(id));
        return "appusers/form";
    }

    @RequestMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("agents",travelAgentService.list());
        model.addAttribute("appuser", new AppUser());
        return "appusers/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(AppUser appUser){
        appUserService.save(appUser);
        return "redirect:list";
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("appuser", appUserService.getById(id));
        return "appusers/card";
    }

}
