package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    private final ClientService clientService;
    private final DocumentTypeService documentTypeService;

    @Autowired
    public ClientServiceTest(ClientService clientService,
                             DocumentTypeService documentTypeService) {
        this.clientService = clientService;
        this.documentTypeService = documentTypeService;
    }

    @Test
    public void list() {
        Integer expected = 6;
        Integer actual = clientService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Client client = clientService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,client.getClientId());
    }

    @Test
    public void save() {
        Client newClient = new Client(documentTypeService.getById(1),"1122 112233","dw","wd","wd","wd","21w112");
        clientService.save(newClient);

        Assert.assertNotNull(clientService.getById(6));
    }

    @Test
    public void delete() {
        clientService.delete(7);
        Assert.assertEquals(6, clientService.list().size());
    }
}