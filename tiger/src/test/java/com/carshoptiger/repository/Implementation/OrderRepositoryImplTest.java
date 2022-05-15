package com.carshoptiger.repository.Implementation;

import com.carshoptiger.config.BeansConfig;
import com.carshoptiger.domain.Order;
import com.carshoptiger.repository.API.OrderRepository;
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
public class OrderRepositoryImplTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void SaveOrder() {
        Order order = new Order();
        order.setName("test");
        order.setSoname("soname");
        order.setFaname("faname");
        order.setPriceorder("1231");
        order.setCountry("country");
        order.setCity("city");
        order.setAddress("Address");
        order.setContactphone("Contact");
        order.setCommentorder("Comment");
        order.setDate_order(new Date(new java.util.Date().getTime()));
        order.setId_car(775L);
        order.setStatus_order("Process");

        boolean result_save = orderRepository.saveorder(order);

        Assert.assertTrue(result_save);
    }

    @Test
    public void UpdateOrder() {
        Order order = orderRepository.getorderbyid(779L);

        order.setName("Test");

        boolean result_update = orderRepository.updateorder(order);

        Assert.assertTrue(result_update);
    }

    @Test
    public void DeleteOrder() {
       Order order = orderRepository.getorderbyid(779L);

       boolean resulte_delete =  orderRepository.deleteorder(order);

       Assert.assertTrue(resulte_delete);
    }

    @Test
    public void FindAllOrder() {
        Assert.assertEquals(1, orderRepository.findAllOrder().size());
    }

    @Test
    public void GetById() {
        Assert.assertNotNull(orderRepository.getorderbyid(779L));
    }
}