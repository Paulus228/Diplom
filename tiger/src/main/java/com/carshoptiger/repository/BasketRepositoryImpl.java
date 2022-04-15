package com.carshoptiger.repository;

import com.carshoptiger.domain.Basket;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class BasketRepositoryImpl implements BasketRepository{
    private final JdbcTemplate databaseMysql;

    @Override
    public boolean save(Basket basket, Long id_user) {
        return databaseMysql.update("INSERT INTO basketcar(id_basket_user,id_car,date_add) VALUES(" +
                "(SELECT id_basket FROM basketuser WHERE id_user = ?),?,?)",
                id_user,basket.getId_car(), new Date())>0;
    }

    @Override
    public boolean delete(Basket basket, Long id_user) {
        return databaseMysql.update("DELETE FROM basketcar WHERE ctid IN(SELECT ctid FROM basketcar" +
                " WHERE id_basket_user=(SELECT id_basket FROM basketuser WHERE id_user = ?) AND id_car=? LIMIT 1",id_user,basket.getId_car())>0;
    }

    @Override
    public List<Basket> findAllByBasketId(Long id_user) {
        return databaseMysql.query("SELECT * FROM basketcar WHERE id_basket_user=(SELECT id_basket FROM basketuser WHERE id_user = ?)",
                new BeanPropertyRowMapper<>(Basket.class),id_user);
    }

    @Override
    public boolean InitBasket(Long id_user) {
        return databaseMysql.update("INSERT INTO basket_user(id_user) VALUES(?)")>0;
    }

    @Override
    public boolean DestroyBasket(Long id_user) {
        return databaseMysql.update("DELETE FROM basketcar WHERE id_basket_user=(SELECT id_basket FROM basketuser WHERE id_user = ?)",id_user)>0;
    }
}
