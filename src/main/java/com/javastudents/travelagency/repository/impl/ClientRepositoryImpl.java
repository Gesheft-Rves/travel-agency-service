package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Client;
import com.javastudents.travelagency.repository.ClientRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Client client) {
        @Language("MySQL")
        String query = "INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                client.getDocumentTypeId(),
                client.getDocumentSeriesNumber(),
                client.getName(),
                client.getSurname(),
                client.getPatronymic(),
                client.getAddress(),
                client.getPhoneNumber()
        );
    }

    @Override
    public Client read(int clientId) {
        @Language("MySQL")
        String query = "SELECT * FROM client WHERE client_id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{clientId},

                    (rs, rowNum) -> Client.builder()
                            .clientId(rs.getInt("client_id"))
                            .documentTypeId(rs.getInt("document_type_id"))
                            .documentSeriesNumber(rs.getString("document_series_number"))
                            .name(rs.getString("name"))
                            .surname(rs.getString("surname"))
                            .patronymic(rs.getString("patronymic"))
                            .address(rs.getString("address"))
                            .phoneNumber(rs.getString("phone_number"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Client client) {
        @Language("MySQL")
        String query = "UPDATE client SET document_type_id = ?, document_series_number = ?, name = ?, surname = ?, patronymic = ?, address = ?, phone_number = ? WHERE client_id = ?";

        jdbcTemplate.update(
                query,
                client.getDocumentTypeId(),
                client.getDocumentSeriesNumber(),
                client.getName(),
                client.getSurname(),
                client.getPatronymic(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getClientId()
        );
    }

    @Override
    public void delete(int clientId) {
        @Language("MySQL")
        String query = "DELETE FROM client WHERE client_id = ?";

        jdbcTemplate.update(query, clientId);
    }
}
