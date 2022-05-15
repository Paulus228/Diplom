package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.Role;
import com.carshoptiger.domain.User;
import com.carshoptiger.repository.API.UserRepository;
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
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void SaveUser() {
        User user = new User();
        user.setId(77L);
        user.setName("name");
        user.setSoname("soname");
        user.setUsername("username");
        user.setPassword("password");
        user.setRoles(Role.USER);
        user.setActivationcode("activea");
        user.setEmail("email");
        user.setDate_add(new Date(new java.util.Date().getTime()));

        boolean result_save = userRepository.saveuser(user);

        Assert.assertTrue(result_save);
    }

    @Test
    public void UpdateUser() {
        User user = userRepository.getuserbyid(778L);

        user.setName("TEST");

        boolean result_update = userRepository.updateuser(user);

        Assert.assertTrue(result_update);
    }

    @Test
    public void DeleteUser() {
        User user = userRepository.getuserbyid(779L);

        boolean result_delete = userRepository.deleteuser(user);

        Assert.assertTrue(result_delete);

    }

    @Test
    public void FindAllUser() {
        Assert.assertEquals(2, userRepository.findAllUser().size());
    }

    @Test
    public void FindByUsername() {
        Assert.assertNotNull(userRepository.findUserByUsername("test", ""));
    }

    @Test
    public void GetUserByID() {
        Assert.assertNotNull(userRepository.getuserbyid(778L));
    }

    @Test
    public void FindUserByActivationCode() {
        Assert.assertNotNull(userRepository.findUserByActivationCode("acivate"));
    }
}