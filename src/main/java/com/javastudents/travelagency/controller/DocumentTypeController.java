package com.javastudents.travelagency.controller;

import com.javastudents.travelagency.entity.DocumentType;
import com.javastudents.travelagency.service.impl.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/documenttype")
public class DocumentTypeController {
    private DocumentTypeServiceImpl documentTypeService;

    @Autowired
    public void setDocumentTypeService(DocumentTypeServiceImpl documentTypeService){
        this.documentTypeService = documentTypeService;
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("doctypes", documentTypeService.list());
        return "documenttype/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        documentTypeService.delete(id);
        return "redirect:/documenttype/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, Model model){
        model.addAttribute("doctype", documentTypeService.read(id));
        return "documenttype/form";
    }

    @RequestMapping("/new")
    public String newAppPermission(Model model){
        model.addAttribute("doctype", new DocumentType());
        return "documenttype/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(DocumentType documentType){
        boolean newRecord = documentType.getDocumentTypeId()== null;
        if(newRecord){
            documentTypeService.create(documentType);
        } else {
            documentTypeService.update(documentType);
        }
        return "redirect:/documenttype/list";
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("doctype", documentTypeService.read(id));
        return "documenttype/card";
    }
}
