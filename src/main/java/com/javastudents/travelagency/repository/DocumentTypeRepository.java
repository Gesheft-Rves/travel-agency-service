package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.DocumentType;

import java.util.List;

public interface DocumentTypeRepository extends CrudRepository<DocumentType> {
    List<DocumentType> list();
}
