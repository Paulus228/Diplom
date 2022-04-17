package com.carshoptiger.configuration;

import com.carshoptiger.repository.API.*;
import com.carshoptiger.repository.Implementation.*;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.service.API.ContactService;
import com.carshoptiger.service.API.TestimonalsService;
import com.carshoptiger.service.API.UserService;
import com.carshoptiger.service.Implementation.CarServiceImpl;
import com.carshoptiger.service.Implementation.ContactServiceImpl;
import com.carshoptiger.service.Implementation.TestimonalsServiceImpl;
import com.carshoptiger.service.Implementation.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("guest_user");
        dataSource.setPassword("guest_password");

        return dataSource;
    }

    @Bean
    public JdbcTemplate database(){
        return new JdbcTemplate(mysqlDataSource());
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImpl(database());
    }

    @Bean
    public BasketRepository basketRepository(){return new BasketRepositoryImpl(database());}

    @Bean
    public CarRepository carRepository(){return new CarRepositoryImpl(database());}

    @Bean
    public CarExtractRepository carExtractRepository(){return new CarExtractRepositoryImpl(database());}

    @Bean
    public CarInfoRepository carInfoRepository(){
        return new CarInfoRepositoryImpl(database());
    }

    @Bean
    public CarPhotoRepository carPhotoRepository(){return new CarPhotoRepositoryImpl(database());}

    @Bean
    public ContactsRepository contactsRepository(){
        return new ContactsRepositoryImpl(database());
    }

    @Bean
    public TestimonalsRepository testimonalsRepository(){
        return new TestimonalsRepositoryImpl(database());
    }

    @Bean
    public CarService carService(){
        return new CarServiceImpl(carRepository());
    }

    @Bean
    public UserService userService(){return new UserServiceImpl(userRepository());
    }

    @Bean
    public TestimonalsService testimonalsService(){return new TestimonalsServiceImpl(testimonalsRepository());
    }

    @Bean
    public ContactService contactService(){return new ContactServiceImpl(contactsRepository());
    }
}
