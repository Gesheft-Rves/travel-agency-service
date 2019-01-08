package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.DocumentType;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DocumentTypeRepositoryTest extends AbstractTest implements CrudTest{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DocumentTypeRepository repository;

    @Test
    @Override
    public void createTest() {
        String docTypeName = "Test docTypeName";

        DocumentType documentType = DocumentType.builder()
                .name(docTypeName)
                .build();

        repository.create(documentType);

        @Language("MySQL")
        String sql = "SELECT name from document_type where document_type_id = (select max(document_type_id) from document_type)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(docTypeName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String expected = "document_type_1";
        DocumentType byId = repository.read(1);

        Assert.assertEquals(expected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String expectedValue = "New documentType";
        DocumentType documentType = repository.read(2);
        documentType.setName(expectedValue);
        repository.update(documentType);

        Assert.assertEquals(expectedValue, repository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {

        repository.delete(5);

        Assert.assertNull(repository.read(5));
    }
}
