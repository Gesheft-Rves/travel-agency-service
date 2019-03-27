package com.javastudents.travelagency.controller;


import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelAgent")
public class TravelAgentController {

    private TravelAgentServiceImpl travelAgentService;
    private TravelAgencyServiceImpl travelAgencyService;

    @Autowired
    public TravelAgentController(TravelAgentServiceImpl travelAgentService, TravelAgencyServiceImpl travelAgencyService) {
        this.travelAgentService = travelAgentService;
        this.travelAgencyService = travelAgencyService;
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("travelAgents", travelAgentService.list());
        return "travelAgent/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        travelAgentService.delete(id);
        return "redirect:/travelAgent/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgent", travelAgentService.read(id));
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("travelAgent", new TravelAgent());
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @PostMapping("/save")
    public String save(TravelAgent travelAgent){
        System.out.println(travelAgent.toString());
        if(travelAgent.getId()== null){
            travelAgentService.create(travelAgent);
        } else {
            travelAgentService.update(travelAgent);
        }
        return "redirect:/travelAgent/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgent", travelAgentService.read(id));
        return "travelAgent/card";
    }
}
