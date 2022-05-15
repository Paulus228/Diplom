package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.CarPhoto;
import com.carshoptiger.repository.API.CarPhotoRepository;
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
public class CarPhotoRepositoryImplTest {

    @Autowired
    private CarPhotoRepository carPhotoRepository;

    @Test
    public void SaveCarPhoto() {
        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setId_car(775L);
        carPhoto.setPhotourl("PhotoUrl");
        carPhoto.setId(777L);

        boolean result_save = carPhotoRepository.savecarphoto(carPhoto);

        Assert.assertTrue(result_save);
    }

    @Test
    public void DeleteCarPhoto() {
        boolean result_delete = carPhotoRepository.deletecarphoto(776L);

        Assert.assertTrue(result_delete);
    }

    @Test
    public void FindAllCarPhoto() {
        Assert.assertEquals(2, carPhotoRepository.findallByidCar(775L).size());
    }
}