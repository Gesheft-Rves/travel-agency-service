package com.javastudents.travelagency.service;


import com.javastudents.travelagency.entity.DocumentType;

import java.util.List;

public interface DocumentTypeService extends PojoService<DocumentType> {
    List<DocumentType> list();
    DocumentType getById(Integer id);
    DocumentType save(DocumentType obj);
    void delete(Integer id);
}
