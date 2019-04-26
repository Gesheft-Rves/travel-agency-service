package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.DocumentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTypeServiceTest {

    private DocumentTypeService documentTypeService;

    @Autowired
    public void setDocumentTypeService(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @Test
    public void list() {
        Integer expected = 5;
        Integer actual = documentTypeService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        DocumentType documentType = documentTypeService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,documentType.getDocumentTypeId());
    }

    @Test
    public void save() {
        DocumentType newDocumentType = new DocumentType(6,"WEWEWE");
        documentTypeService.save(newDocumentType);

        Assert.assertNotNull(documentTypeService.getById(6));
    }

    @Test
    public void delete() {
        DocumentType newDocumentType = new DocumentType(6,"WEWEWE");
        documentTypeService.save(newDocumentType);

        Assert.assertNotNull(documentTypeService.getById(6));
        documentTypeService.delete(6);

        Assert.assertEquals(5, documentTypeService.list().size());
    }
}