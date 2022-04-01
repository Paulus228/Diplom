package com.carshoptiger.configuration;

import com.carshoptiger.repository.UserRepository;
import com.carshoptiger.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.carshoptiger")
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
}
