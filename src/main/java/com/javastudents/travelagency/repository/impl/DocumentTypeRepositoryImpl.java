package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.DocumentType;
import com.javastudents.travelagency.repository.DocumentTypeRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentTypeRepositoryImpl implements DocumentTypeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DocumentTypeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void create(DocumentType documentType) {
        @Language("MySQL")
        String query = "INSERT INTO document_type (name) VALUES (?)";

        jdbcTemplate.update(query, documentType.getName());
    }

    @Override
    public DocumentType read(int documentTypeId) {
        @Language("MySQL")
        String query = "SELECT * FROM document_type WHERE document_type_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{documentTypeId},

                    (rs, rowNum) -> DocumentType.builder()
                            .documentTypeId(rs.getInt("document_type_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(DocumentType documentType) {
        @Language("MySQL")
        String query = "UPDATE document_type SET name = ? WHERE document_type_id = ?";

        jdbcTemplate.update(query, documentType.getName(), documentType.getDocumentTypeId());
    }

    @Override
    public void delete(int documentTypeId) {
        @Language("MySQL")
        String query = "DELETE FROM document_type WHERE document_type_id = ?";

        jdbcTemplate.update(query, documentTypeId);
    }

    @Override
    public List<DocumentType> list() {
        @Language("MySQL")
        String query = "SELECT * FROM document_type";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> DocumentType.builder()
                            .documentTypeId(rs.getInt("document_type_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
