package com.javastudents.travelagency.controller;


import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/travelAgent")
public class TravelAgentController {

    private final TravelAgentServiceImpl travelAgentServiceImpl;
    private final TravelAgencyServiceImpl travelAgencyServiceImpl;

    @Autowired
    public TravelAgentController(TravelAgentServiceImpl travelAgentServiceImpl,
                                 TravelAgencyServiceImpl travelAgencyServiceImpl) {
        this.travelAgentServiceImpl = travelAgentServiceImpl;
        this.travelAgencyServiceImpl = travelAgencyServiceImpl;
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("travelAgents", travelAgentServiceImpl.list());
        return "travelAgent/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        travelAgentServiceImpl.delete(id);
        return "redirect:/travelAgent/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgent", travelAgentServiceImpl.getById(id));
        model.addAttribute("travelAgencies", travelAgencyServiceImpl.list());
        return "travelAgent/form";
    }

    @GetMapping("/new")
    public String newTravelAgent(Model model){
        model.addAttribute("travelAgent", new TravelAgent());
        model.addAttribute("travelAgencies", travelAgencyServiceImpl.list());
        return "travelAgent/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("travelAgent") TravelAgent travelAgent){
        travelAgentServiceImpl.save(travelAgent);
        return "redirect:/travelAgent/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("travelAgent", travelAgentServiceImpl.getById(id));
        return "travelAgent/card";
    }
}
