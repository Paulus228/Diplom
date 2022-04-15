package com.carshoptiger.repository;

import com.carshoptiger.domain.CarPhoto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class CarPhotoRepositoryImpl implements CarPhotoRepository{

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean savecarphoto(CarPhoto carPhoto) {
        return databaseMysql.update("INSERT INTO carphoto(id_car,photourl) VALUES(?,?)",
                carPhoto.getId_car(),carPhoto.getPhotourl())>0;
    }

    @Override
    public boolean deletecarphoto(Long id_carphoto) {
        return databaseMysql.update("DELETE FROM carphoto WHERE id = ?",id_carphoto)>0;
    }

    @Override
    public List<CarPhoto> findallByidCar(Long id_car) {
        return databaseMysql.query("SELECT * FROM carphoto WHERE id_car=?",
                new BeanPropertyRowMapper<>(CarPhoto.class),id_car);
    }
}
