package com.carshoptiger.repository.API;

import com.carshoptiger.domain.CarPhoto;

import java.util.List;

public interface CarPhotoRepository {
    boolean savecarphoto(CarPhoto carPhoto);
    boolean deletecarphoto(Long id_carphoto);
    List<CarPhoto>findallByidCar(Long id_car);
}
