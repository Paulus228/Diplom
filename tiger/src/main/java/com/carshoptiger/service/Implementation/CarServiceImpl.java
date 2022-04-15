package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.repository.API.CarRepository;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.util.validators.CarValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public boolean savecar(Car car) {
        boolean result_save;
        Car carIsexists = carRepository.findCarByName(car.getName()).get(0);
        if(carIsexists==null){
            if(CarValidator.CarValidation(car)){
                result_save = carRepository.savecar(car);
            }else{
                result_save=false;
            }
        }else {
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean updatecar(Car car) {
        boolean result_update;
        Car carIsExists=carRepository.getonecar(car.getId());
        if(carIsExists!=null){
            if(CarValidator.CarValidation(car)){
                result_update = carRepository.updatecar(car);
            }else{
                result_update = false;
            }
        }else{
            result_update = false;
        }
        return result_update;
    }

    @Override
    public boolean deletecar(Long id_car) {
        boolean result_delete;
        Car carIsExists = carRepository.getonecar(id_car);
        if(carIsExists!=null){
            result_delete = carRepository.deletecar(id_car);
        }else{
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public Car getonecar(Long id_car) {
        return carRepository.getonecar(id_car);
    }

    @Override
    public List<Car> findAllCar() {
        return carRepository.findAllCar();
    }

    @Override
    public List<Car> findCarByName(String name) {
        if(name.equals("")){
            return carRepository.findAllCar();
        }else{
            return carRepository.findCarByName(name);
        }
    }
}
