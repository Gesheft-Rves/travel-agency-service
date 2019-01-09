package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Client;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Override
    public void createTest() {
        String name = "New clientName";

        Client client = Client.builder()
                .documentTypeId(1)
                .documentSeriesNumber("")
                .name(name)
                .surname("")
                .patronymic("")
                .address("")
                .phoneNumber(123456789)
                .build();

        clientRepository.create(client);

        @Language("MySQL")
        String sql = "SELECT name from client where client_id = (select max(client_id) from client)";
        String nameDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(name, nameDB);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "client_name_1";
        Client byId = clientRepository.read(1);

        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "New clientName";
        Client client = clientRepository.read(1);
        client.setName(nameExpected);
        clientRepository.update(client);

        Assert.assertEquals(nameExpected, clientRepository.read(1).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        clientRepository.delete(5);

        Assert.assertNull(clientRepository.read(5));
    }
}
