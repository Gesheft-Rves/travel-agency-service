package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.DocumentType;

import java.util.List;

public interface DocumentTypeService extends CrudService<DocumentType> {
    List<DocumentType> list();
}
