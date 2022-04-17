package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.CarExtract;
import com.carshoptiger.repository.API.CarExtractRepository;
import com.carshoptiger.service.API.CarExtractService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.util.validators.CarExtractValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CarExtractServiceImpl implements CarExtractService {

    private final CarExtractRepository carExtractRepository;

    private final CarService carService;

    @Override
    public boolean savecarextract(CarExtract carExtract) {
        boolean result_save;
        Car carIsexist = carService.getonecar(carExtract.getId_car());
        if (carIsexist != null) {
            if (CarExtractValidator.CarExtractValidation(carExtract)) {
                result_save = carExtractRepository.savecarextract(carExtract);
            } else {
                result_save = false;
            }
        } else {
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean updatecarextract(CarExtract carExtract) {
        boolean result_update;
        if (carExtract.getId() != null) {
            if (CarExtractValidator.CarExtractValidation(carExtract)) {
                result_update = carExtractRepository.updatecarextract(carExtract);
            } else {
                result_update = false;
            }
        } else {
            result_update = false;
        }
        return result_update;
    }

    @Override
    public boolean deletecarextract(Long id_car_extract) {
        boolean result_delete;
        if (id_car_extract != null) {
            result_delete = carExtractRepository.deletecarextract(id_car_extract);
        } else {
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<CarExtract> findcarextractbycarid(Long id_car) {
        Car carIsExists = carService.getonecar(id_car);
        if(carIsExists!=null){
            return carExtractRepository.findcarextractbycarid(id_car);
        }else{
            return null;
        }
    }
}
