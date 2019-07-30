package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.User;
import com.javastudents.travelagency.service.UserService;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private TravelAgentService travelAgentService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTravelAgentService(TravelAgentService travelAgentService) {
        this.travelAgentService = travelAgentService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> users = userService.list();
        model.addAttribute("userslist", users);
        return "users/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        userService.delete(id);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("agents",travelAgentService.list());
        model.addAttribute("user", userService.getById(id));
        return "users/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("agents",travelAgentService.list());
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "users/card";
    }

}
