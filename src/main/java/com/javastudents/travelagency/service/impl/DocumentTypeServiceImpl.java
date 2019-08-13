package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.DocumentType;
import com.javastudents.travelagency.repository.DocumentTypeRepository;
import com.javastudents.travelagency.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repository;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocumentType> list() {
        return repository.findAll();
    }

    @Override
    public DocumentType getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public DocumentType save(DocumentType obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
