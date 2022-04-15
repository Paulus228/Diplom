package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.CarExtract;
import com.carshoptiger.repository.API.CarExtractRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class CarExtractRepositoryImpl implements CarExtractRepository {
    private final JdbcTemplate databaseMySql;

    @Override
    public boolean savecarextract(CarExtract carExtract) {
        return databaseMySql.update("INSERT INTO carextract(id_car,extract)VALUES(?,?)",carExtract.getId_car(),carExtract.getExtract())>0;
    }

    @Override
    public boolean updatecarextract(CarExtract carExtract) {
        return databaseMySql.update("UPDATE carextract SET extract=? WHERE id=?",carExtract.getId())>0;
    }

    @Override
    public boolean deletecarextract(Long id_car_extract) {
        return databaseMySql.update("DELETE FROM carextract WHERE id = ?",id_car_extract)>0;
    }

    @Override
    public List<CarExtract> findcarextractbycarid(Long id_car) {
        return databaseMySql.query("SELECT * FROM carextract WHERE id_car = ?",new BeanPropertyRowMapper<>(CarExtract.class),id_car);
    }
}
