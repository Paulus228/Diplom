package com.carshoptiger.service.API;

import com.carshoptiger.domain.Car;

import java.util.List;

public interface CarService {
    boolean savecar(Car car);
    boolean updatecar(Car car);
    boolean deletecar(Long id_car);
    Car getonecar(Long id_car);
    List<Car> findAllCar();
    List<Car>findCarByName(String name);
}
