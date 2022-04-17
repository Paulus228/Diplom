package com.carshoptiger.service.Implementation;

import com.carshoptiger.domain.Car;
import com.carshoptiger.domain.CarInfo;
import com.carshoptiger.repository.API.CarInfoRepository;
import com.carshoptiger.service.API.CarInfoService;
import com.carshoptiger.service.API.CarService;
import com.carshoptiger.util.validators.CarInfoValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarInfoServiceImpl implements CarInfoService {

    private final CarInfoRepository carInfoRepository;

    private final CarService carService;

    @Override
    public boolean savecarinfo(CarInfo carInfo) {
        boolean result_save;
        Car carIsexists = carService.getonecar(carInfo.getId_car());
        if (carIsexists != null) {
            if (CarInfoValidator.CarInfoValidation(carInfo)) {
                result_save = carInfoRepository.savecarinfo(carInfo);
            } else {
                result_save = false;
            }
        } else {
            result_save = false;
        }

        return result_save;
    }

    @Override
    public boolean updatecarinfo(CarInfo carInfo) {
        boolean result_update;
        if (carInfo.getId() != null) {
            if (CarInfoValidator.CarInfoValidation(carInfo)) {
                result_update = carInfoRepository.updatecarinfo(carInfo);
            } else {
                result_update = false;
            }
        } else {
            result_update = false;
        }
        return result_update;
    }

    @Override
    public CarInfo getonecarinfobycarid(Long id_car) {
        if (id_car != null) {
            return carInfoRepository.getonecarinfobycarid(id_car);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletecarinfo(Long id_carinfo) {
        boolean result_delete;
        CarInfo carinfoIsexists = carInfoRepository.getonecarinfobycarid(id_carinfo);
        if (carinfoIsexists != null) {
            result_delete = carInfoRepository.deletecarinfo(id_carinfo);
        } else {
            result_delete = false;
        }
        return result_delete;
    }
}
