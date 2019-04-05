package com.javastudents.travelagency.controller;


import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.entity.dto.TravelAgentDTO;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        TravelAgentDTO travelAgentDTO = travelAgent2DTO(travelAgentService.read(id));
        model.addAttribute("travelAgentDTO", travelAgentDTO);
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("travelAgentDTO", new TravelAgentDTO());
        model.addAttribute("travelAgencies", travelAgencyService.list());
        return "travelAgent/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("travelAgentDTO") TravelAgentDTO travelAgentDTO){
        TravelAgent travelAgent = dto2TravelAgent(travelAgentDTO);
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

    private TravelAgentDTO travelAgent2DTO(TravelAgent travelAgent) {
        return TravelAgentDTO.builder()
                .id(travelAgent.getId())
                .travelAgencyId(travelAgent.getTravelAgency().getId())
                .name(travelAgent.getName())
                .surname(travelAgent.getSurname())
                .patronymic(travelAgent.getPatronymic())
                .enabled(travelAgent.getEnabled())
                .phoneNumber(travelAgent.getPhoneNumber())
                .limitAmount(travelAgent.getLimitAmount())
                .build();
    }

    private TravelAgent dto2TravelAgent (TravelAgentDTO travelAgentDTO) {
        return TravelAgent.builder()
                .id(travelAgentDTO.getId())
                .travelAgency(travelAgencyService.read(travelAgentDTO.getTravelAgencyId()))
                .name(travelAgentDTO.getName())
                .surname(travelAgentDTO.getSurname())
                .patronymic(travelAgentDTO.getPatronymic())
                .enabled(travelAgentDTO.getEnabled())
                .phoneNumber(travelAgentDTO.getPhoneNumber())
                .limitAmount(travelAgentDTO.getLimitAmount())
                .build();
    }
}
