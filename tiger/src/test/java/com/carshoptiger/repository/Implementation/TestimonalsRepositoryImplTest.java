package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.Testimonals;
import com.carshoptiger.repository.API.TestimonalsRepository;
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
public class TestimonalsRepositoryImplTest {

    @Autowired
    private TestimonalsRepository testimonalsRepository;

    @Test
    public void SaveTestimonals() {
        Testimonals testimonals = new Testimonals();
        testimonals.setFullname("TestTesti");
        testimonals.setMessage_testimonals("Testtest");
        testimonals.setDate_send(new Date(new java.util.Date().getTime()));

        boolean result_save = testimonalsRepository.savetestimonals(testimonals);

        Assert.assertTrue(result_save);
    }

    @Test
    public void DeleteTestimonals() {
        boolean result_delete = testimonalsRepository.deletetestimonals(777L);

        Assert.assertTrue(result_delete);
    }

    @Test
    public void FindAllTestimonals() {
        Assert.assertEquals(1, testimonalsRepository.findAllTestimonals().size());
    }
}