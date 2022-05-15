package test.carshoptiger.repository.Implementation;


import com.carshoptiger.domain.Car;
import com.carshoptiger.repository.API.CarRepository;
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
import test.carshoptiger.config.BeansConfig;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = BeansConfig.class)
@WebAppConfiguration
@ComponentScan("com.sportguru.dao.impl")
@Sql(value = {"classpath:/scripts/destroy_sql_data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CarRepositoryImplTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void SaveCar() {
        Car car = new Car();
        car.setId(777L);
        car.setName("TestName");
        car.setDescription("TestDescription");
        car.setPrice(3123F);
        car.setDate_add(new Date(new java.util.Date().getTime()));
        car.setCount_buy(0);

        carRepository.savecar(car);

        boolean result_save = carRepository.savecar(car);

        Assert.assertTrue(result_save);
    }


}