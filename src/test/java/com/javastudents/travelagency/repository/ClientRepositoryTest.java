package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Client;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Override
    public void createTest() {
        String clientName = "New clientName";

        Client client = Client.builder()
                .documentTypeId(1)
                .documentSeriesNumber("")
                .name(clientName)
                .surname("")
                .patronymic("")
                .address("")
                .phoneNumber(123456789)
                .build();

        clientRepository.create(client);

        @Language("MySQL")
        String sql = "SELECT name from client where client_id = (select max(client_id) from client)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(clientName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String expected = "client_name_1";
        Client byId = clientRepository.read(1);

        Assert.assertNotNull(byId);
        Assert.assertEquals(expected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String expectedValue = "New clientName";
        Client client = clientRepository.read(1);
        client.setName(expectedValue);

        clientRepository.update(client);

        Client newClient = clientRepository.read(1);

        Assert.assertNotNull(newClient);
        Assert.assertEquals(client.getClientId(), newClient.getClientId());

        Assert.assertEquals(expectedValue, newClient.getName());
    }

    @Test
    @Override
    public void deleteTest() {

        clientRepository.delete(5);

        Assert.assertNull(clientRepository.read(5));
    }
}