package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.CarInfo;
import com.carshoptiger.repository.API.CarInfoRepository;
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
public class CarInfoRepositoryImplTest {

    @Autowired
    private CarInfoRepository carInfoRepository;

    @Test
    public void SaveCarInfo() {
        CarInfo carInfo = new CarInfo();
        carInfo.setId_car(775L);
        carInfo.setType("Type");
        carInfo.setMake("Make");
        carInfo.setModel("Model");
        carInfo.setMileage(123);
        carInfo.setFirst_reg(new Date(new java.util.Date().getTime()));
        carInfo.setFuel("fuel");
        carInfo.setEnginesize(123);
        carInfo.setPower(12);
        carInfo.setGearbox("Gear");
        carInfo.setNumberseat(12);
        carInfo.setDoors("12");
        carInfo.setColor("Color");

        boolean result_save = carInfoRepository.savecarinfo(carInfo);

        Assert.assertTrue(result_save);
    }

    @Test
    public void UpdateCarInfo() {
        CarInfo carInfo = carInfoRepository.getonecarinfobycarid(775L);

        carInfo.setPower(123);

        boolean result_update = carInfoRepository.updatecarinfo(carInfo);

        Assert.assertTrue(result_update);
    }

    @Test
    public void getonecarinfobycarid() {
        CarInfo carInfo = carInfoRepository.getonecarinfobycarid(775L);

        Assert.assertNotNull(carInfo);
    }

    @Test
    public void DeleteCarInfo() {
        boolean result_delete = carInfoRepository.deletecarinfo(779L);

        Assert.assertTrue(result_delete);

    }
}