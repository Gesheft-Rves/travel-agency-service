package com.javastudents.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping({"/", "/home"})
    public String index() {
        return "index";
    }
}
