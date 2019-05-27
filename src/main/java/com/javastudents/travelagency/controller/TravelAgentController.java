package com.javastudents.travelagency.controller;


import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.service.TravelAgencyService;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/travelAgent")
public class TravelAgentController {

    private TravelAgentService travelAgentService;
    private TravelAgencyService travelAgencyService;

    @Autowired
    public TravelAgentController(TravelAgentService travelAgentService, TravelAgencyService travelAgencyService) {
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
        model.addAttribute("travelAgent", travelAgentService.getById(id));
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @GetMapping("/new")
    public String newTravelAgent(Model model){
        model.addAttribute("travelAgent", new TravelAgent());
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("travelAgent") TravelAgent travelAgent){
        travelAgentService.save(travelAgent);
        return "redirect:/travelAgent/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgent", travelAgentService.getById(id));
        return "travelAgent/card";
    }
}
