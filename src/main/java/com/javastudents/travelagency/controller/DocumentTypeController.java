package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.DocumentType;
import com.javastudents.travelagency.service.impl.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctype")
public class DocumentTypeController {

    private final DocumentTypeServiceImpl documentTypeServiceImpl;

    @Autowired
    public DocumentTypeController(DocumentTypeServiceImpl documentTypeServiceImpl) {
        this.documentTypeServiceImpl = documentTypeServiceImpl;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("doctypes", documentTypeServiceImpl.list());
        return "doctype/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        documentTypeServiceImpl.delete(id);
        return "redirect:/doctype/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("doctype", documentTypeServiceImpl.getById(id));
        return "doctype/form";
    }

    @GetMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("doctype", new DocumentType());
        return "doctype/form";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("doctType") DocumentType doctType){
        documentTypeServiceImpl.save(doctType);
        return "redirect:/doctype/list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("doctype", documentTypeServiceImpl.getById(id));
        return "doctype/card";
    }

}
