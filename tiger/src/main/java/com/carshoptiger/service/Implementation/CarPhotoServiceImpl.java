package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.CarPhoto;
import com.carshoptiger.repository.API.CarPhotoRepository;
import com.carshoptiger.service.API.CarPhotoService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.util.validators.CarPhotoValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CarPhotoServiceImpl implements CarPhotoService {

    private final CarPhotoRepository carPhotoRepository;

    private final CarService carService;

    @Override
    public boolean savecarphoto(CarPhoto carPhoto) {
        boolean result_save;
        Car carIsexists = carService.getonecar(carPhoto.getId_car());
        if (carIsexists != null) {
            if (CarPhotoValidator.CarPhotoValidation(carPhoto)) {
                result_save = carPhotoRepository.savecarphoto(carPhoto);
            } else {
                result_save = false;
            }
        } else {
            result_save = false;
        }
        return result_save;
    }

    @Override
    public boolean deletecarphoto(Long id_carphoto) {
        boolean result_delete;
        if (id_carphoto != null) {
            result_delete = carPhotoRepository.deletecarphoto(id_carphoto);
        } else {
            result_delete = false;
        }
        return result_delete;
    }

    @Override
    public List<CarPhoto> findallByidCar(Long id_car) {
        Car carIsexists = carService.getonecar(id_car);
        if (carIsexists != null) {
            return carPhotoRepository.findallByidCar(id_car);
        } else {
            return null;
        }
    }
}
