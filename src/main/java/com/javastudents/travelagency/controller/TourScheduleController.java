package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.entity.dto.TourScheduleDTO;
import com.javastudents.travelagency.service.TourScheduleService;
import com.javastudents.travelagency.service.TourService;
import com.javastudents.travelagency.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/tourSchedule")
public class TourScheduleController {

    private final TourScheduleService tourScheduleService;
    private final TourService tourService;
    private final TransportService transportService;

    @Autowired
    public TourScheduleController(TourScheduleService tourScheduleService,
                                  TourService tourService,
                                  TransportService transportService) {
        this.tourScheduleService = tourScheduleService;
        this.tourService = tourService;
        this.transportService = transportService;
    }



    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("tourSchedules", tourScheduleService.list());
        return "tourSchedule/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        tourScheduleService.delete(id);
        return "redirect:/tourSchedule/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("tourSchedule", tourScheduleService.getById(id));
        model.addAttribute("tours", tourService.list());
        model.addAttribute("transports", transportService.list());
        return "tourSchedule/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTourSchedule(Model model){
        model.addAttribute("tourSchedule", new TourSchedule());
        model.addAttribute("tours", tourService.list());
        model.addAttribute("transports", transportService.list());
        return "tourSchedule/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("tourSchedule") TourScheduleDTO tourScheduleDTO){
        TourSchedule tourSchedule = tourScheduleDtoToTourSchedule(tourScheduleDTO);
        tourScheduleService.save(tourSchedule);
        return "redirect:/tourSchedule/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("tourSchedule", tourScheduleService.getById(id));
        return "tourSchedule/card";
    }

    private TourSchedule tourScheduleDtoToTourSchedule(TourScheduleDTO tourScheduleDTO){
        return TourSchedule.builder()
                .id(tourScheduleDTO.getId())
                .tour(tourScheduleDTO.getTour())
                .startingDateTime(LocalDateTime.parse(tourScheduleDTO.getStartingDateTime()))
                .endingDateTime(LocalDateTime.parse(tourScheduleDTO.getEndingDateTime()))
                .transport(tourScheduleDTO.getTransport())
                .build();
    }
}
