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
    public void create(DocumentType documentType) {
        repository.create(documentType);
    }

    @Override
    public DocumentType read(int documentTypeId) {
        return repository.read(documentTypeId);
    }

    @Override
    public void update(DocumentType documentType) {
        repository.update(documentType);
    }

    @Override
    public void delete(int documentTypeId) {
        repository.delete(documentTypeId);
    }

    @Override
    public List<DocumentType> list() {
        return repository.list();
    }
}
