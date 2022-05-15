package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.CarExtract;
import com.carshoptiger.repository.API.CarExtractRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = BeansConfig.class)
@WebAppConfiguration
@ComponentScan("com.sportguru.dao.impl")
@Sql(value = {"classpath:/scripts/init_sql_data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"classpath:/scripts/destroy_sql_data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CarExtractRepositoryImplTest {

    @Autowired
    private CarExtractRepository carExtractRepository;

    @Test
    public void SaveCarExtract() {
        CarExtract carExtract = new CarExtract();
        carExtract.setId_car(775L);
        carExtract.setId(777L);
        carExtract.setExtract("Test");

        boolean result_save = carExtractRepository.savecarextract(carExtract);

        Assert.assertTrue(result_save);
    }

    @Test
    public void UpdateCarExtract() {
        CarExtract carExtract = new CarExtract();
        carExtract.setId(777L);
        carExtract.setId_car(775L);
        carExtract.setExtract("Test");

        boolean result_update = carExtractRepository.updatecarextract(carExtract);

        Assert.assertTrue(result_update);
    }

    @Test
    public void DeleteCarExtract() {
        boolean result_delete = carExtractRepository.deletecarextract(778L);
        Assert.assertTrue(result_delete);

    }

    @Test
    public void FindAllCarExtarct() {
        Assert.assertEquals(2, carExtractRepository.findcarextractbycarid(775L).size());
    }
}