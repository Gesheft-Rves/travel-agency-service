package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.User;
import com.javastudents.travelagency.service.impl.UserServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userServiceImpl;
    private TravelAgentServiceImpl travelAgentServiceImpl;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Autowired
    public void setTravelAgentServiceImpl(TravelAgentServiceImpl travelAgentServiceImpl) {
        this.travelAgentServiceImpl = travelAgentServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> users = userServiceImpl.list();
        model.addAttribute("userslist", users);
        return "users/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        userServiceImpl.delete(id);
        return "redirect:/users/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("agents", travelAgentServiceImpl.list());
        model.addAttribute("user", userServiceImpl.getById(id));
        return "users/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("agents", travelAgentServiceImpl.list());
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user){
        userServiceImpl.save(user);
        return "redirect:list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("user", userServiceImpl.getById(id));
        return "users/card";
    }

}
