package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.DocumentType;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.DocumentTypeRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DocumentTypeRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Test
    @Override
    public void createTest() {
        String name = "Test docTypeName";

        DocumentType documentType = DocumentType.builder()
                .name(name)
                .build();

        documentTypeRepository.create(documentType);

        @Language("MySQL")
        String sql = "SELECT name from document_type where document_type_id = (select max(document_type_id) from document_type)";
        String nameDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(name, nameDB);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "document_type_1";
        DocumentType byId = documentTypeRepository.read(1);

        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "New documentType";
        DocumentType documentType = documentTypeRepository.read(2);
        documentType.setName(nameExpected);
        documentTypeRepository.update(documentType);

        Assert.assertEquals(nameExpected, documentTypeRepository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        documentTypeRepository.delete(5);

        Assert.assertNull(documentTypeRepository.read(5));
    }

    @Test
    public void listTest() {
        @Language("MySQL")
        String sql = "SELECT MAX (document_type_id) name from document_type";

        Integer expectedSize = jdbcTemplate.queryForObject(sql, Integer.class);

        List<DocumentType> documentTypeList = documentTypeRepository.list();

        Assert.assertEquals(expectedSize,  (Integer) documentTypeList.size());
    }
}