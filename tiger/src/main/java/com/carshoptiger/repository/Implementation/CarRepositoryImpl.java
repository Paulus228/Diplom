package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.repository.API.CarRepository;
import com.carshoptiger.util.exception.CarNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean savecar(Car car) {
        return databaseMysql.update("INSERT INTO car(name,price,date_add,count_buy,description)VALUES(?,?,?,?,?)",
                car.getName(),car.getPrice(),car.getDate_add(),car.getCount_buy(),car.getDescription())>0;
    }

    @Override
    public boolean updatecar(Car car) {
        return databaseMysql.update("UPDATE car SET car.name=?,price=?,count_buy=?,description=? WHERE id=?"
        ,car.getName(),car.getPrice(),car.getCount_buy(),car.getDescription(),car.getId())>0;
    }

    @Override
    public boolean deletecar(Long id_car) {
        return databaseMysql.update("DELETE FROM car WHERE id = ?",id_car)>0;
    }

    @Override
    public Car getonecar(Long id_car) {
        try {
            return databaseMysql.queryForObject("SELECT * FROM car WHERE id = ?", new BeanPropertyRowMapper<>(Car.class), id_car);
        }catch (CarNotFoundException carNotFoundException){
            return null;
        }
    }

    @Override
    public List<Car> findAllCar() {
        return databaseMysql.query("SELECT * FROM car",new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> findCarByName(String name) {
        String namefind = "%"+name+"%";
        try {
            return databaseMysql.query("SELECT * FROM car WHERE name LIKE ?", new BeanPropertyRowMapper<>(Car.class), namefind);
        }catch (CarNotFoundException carNotFoundException){
            return null;
        }
    }

}
