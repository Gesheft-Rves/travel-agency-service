package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.entity.dto.TourScheduleDTO;
import com.javastudents.travelagency.service.impl.TourScheduleServiceImpl;
import com.javastudents.travelagency.service.impl.TourServiceImpl;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/tourSchedule")
public class TourScheduleController {

    private final TourScheduleServiceImpl tourScheduleServiceImpl;
    private final TourServiceImpl tourServiceImpl;
    private final TransportServiceImpl transportServiceImpl;

    @Autowired
    public TourScheduleController(TourScheduleServiceImpl tourScheduleServiceImpl,
                                  TourServiceImpl tourServiceImpl,
                                  TransportServiceImpl transportServiceImpl) {
        this.tourScheduleServiceImpl = tourScheduleServiceImpl;
        this.tourServiceImpl = tourServiceImpl;
        this.transportServiceImpl = transportServiceImpl;
    }



    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("tourSchedules", tourScheduleServiceImpl.list());
        return "tourSchedule/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        tourScheduleServiceImpl.delete(id);
        return "redirect:/tourSchedule/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("tourSchedule", tourScheduleServiceImpl.getById(id));
        model.addAttribute("tours", tourServiceImpl.list());
        model.addAttribute("transports", transportServiceImpl.list());
        return "tourSchedule/form";
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newTourSchedule(Model model){
        model.addAttribute("tourSchedule", new TourSchedule());
        model.addAttribute("tours", tourServiceImpl.list());
        model.addAttribute("transports", transportServiceImpl.list());
        return "tourSchedule/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("tourSchedule") TourScheduleDTO tourScheduleDTO){
        TourSchedule tourSchedule = tourScheduleDtoToTourSchedule(tourScheduleDTO);
        tourScheduleServiceImpl.save(tourSchedule);
        return "redirect:/tourSchedule/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("tourSchedule", tourScheduleServiceImpl.getById(id));
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
