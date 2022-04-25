package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.Order;
import com.carshoptiger.repository.API.OrderRepository;
import com.carshoptiger.util.exception.OrderNotFountException;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean saveorder(Order order) {
        return databaseMysql.update("INSERT INTO orders(id_car,name, soname, faname, priceorder, country, " +
                        "city, address, contactphone, commentorder, date_order,status_order)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
                order.getId_car(), order.getName(), order.getSoname(), order.getFaname(), order.getPriceorder(), order.getCountry(), order.getCity(),
                order.getAddress(), order.getContactphone(), order.getCommentorder(), order.getDate_order(),order.getStatus_order()) > 0;
    }

    @Override
    public boolean updateorder(Order order) {
        return databaseMysql.update("UPDATE orders SET name=?, soname=?, faname=?, country=?," +
                        "city=?, address=?, contactphone=?,status_order=? WHERE id = ?", order.getName(), order.getSoname(),
                order.getFaname(), order.getCountry(), order.getCity(), order.getAddress(), order.getContactphone(),order.getStatus_order(), order.getId()) > 0;
    }

    @Override
    public boolean deleteorder(Order order) {
        return databaseMysql.update("DELETE FROM orders WHERE id=?", order.getId()) > 0;
    }

    @Override
    public List<Order> findAllOrder() {
        return databaseMysql.query("SELECT * FROM orders", new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public Order getorderbyid(Long id_order) {
        try {
            return databaseMysql.queryForObject("SELECT * FROM orders WHERE id = ?", new BeanPropertyRowMapper<>(Order.class), id_order);
        }catch (OrderNotFountException orderNotFountException){
            return null;
        }
    }
}
