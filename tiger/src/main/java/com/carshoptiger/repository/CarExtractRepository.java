package com.carshoptiger.repository;

import com.carshoptiger.domain.CarExtract;

import java.util.List;

public interface CarExtractRepository {
    boolean savecarextract(CarExtract carExtract);
    boolean updatecarextract(CarExtract carExtract);
    boolean deletecarextract(Long id_car_extract);
    List<CarExtract>findcarextractbycarid(Long id_car);
}
