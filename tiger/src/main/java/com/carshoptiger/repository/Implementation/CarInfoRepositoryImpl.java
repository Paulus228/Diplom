package com.carshoptiger.repository.Implementation;

import com.carshoptiger.domain.CarInfo;
import com.carshoptiger.repository.API.CarInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
public class CarInfoRepositoryImpl implements CarInfoRepository {

    private final JdbcTemplate databaseMysql;

    @Override
    public boolean savecarinfo(CarInfo carInfo) {
        return databaseMysql.update("INSERT INTO carinfo(id_car, type, make, model, first_reg," +
                " mileage, fuel, enginesize, power, gearbox, numberseat, doors, color) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                carInfo.getId_car(),carInfo.getType(),carInfo.getMake(),carInfo.getModel(),carInfo.getFirst_reg(),carInfo.getMileage(),
                carInfo.getFuel(),carInfo.getEnginesize(),carInfo.getPower(),carInfo.getGearbox(),
                carInfo.getNumberseat(),carInfo.getDoors(),carInfo.getColor())>0;
    }

    @Override
    public boolean updatecarinfo(CarInfo carInfo) {
        return databaseMysql.update(" UPDATE carinfo type=?, make=?, model=?, first_reg=?," +
                        " mileage=?, fuel=?, enginesize=?, power=?, gearbox=?, numberseat=?, doors=?, color=? WHERE id=?",
                carInfo.getType(),carInfo.getMake(),carInfo.getModel(),carInfo.getFirst_reg(),carInfo.getMileage(),
                carInfo.getFuel(),carInfo.getEnginesize(),carInfo.getPower(),carInfo.getGearbox(),
                carInfo.getNumberseat(),carInfo.getDoors(),carInfo.getColor(),carInfo.getId())>0;
    }

    @Override
    public CarInfo getonecarinfobycarid(Long id_car) {
        try {
            return databaseMysql.queryForObject("SELECT * FROM carinfo WHERE id_car=?", new BeanPropertyRowMapper<>(CarInfo.class), id_car);
        }catch (EmptyResultDataAccessException carNotFoundException){
            return null;
        }
    }

    @Override
    public boolean deletecarinfo(Long id_carinfo) {
        return databaseMysql.update("DELETE FROM carinfo WHERE id = ?",id_carinfo)>0;
    }
}
