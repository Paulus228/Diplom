package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.Contacts;
import com.carshoptiger.repository.API.ContactsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = BeansConfig.class)
@WebAppConfiguration
@ComponentScan("com.sportguru.dao.impl")
@Sql(value = {"classpath:/scripts/init_sql_data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"classpath:/scripts/destroy_sql_data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ContactsRepositoryImplTest {

    @Autowired
    private ContactsRepository contactsRepository;

    @Test
    public void SaveContact() {
        Contacts contacts = new Contacts();
        contacts.setId(7723L);
        contacts.setFullname("FullName");
        contacts.setEmail("Email");
        contacts.setSubject("Subject");
        contacts.setMessage("Message");
        contacts.setDate_send(new Date(new java.util.Date().getTime()));

        boolean result_save = contactsRepository.savecontact(contacts);

        Assert.assertTrue(result_save);
    }

    @Test
    public void DeleteContact() {
        boolean result_delete = contactsRepository.deletecontact(777L);

        Assert.assertTrue(result_delete);
    }

    @Test
    public void FindAllContacts() {
        Assert.assertEquals(1, contactsRepository.findAllContacts().size());
    }
}