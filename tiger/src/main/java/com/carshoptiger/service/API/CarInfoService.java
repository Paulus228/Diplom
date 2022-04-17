package com.carshoptiger.service.API;

import com.carshoptiger.domain.CarInfo;

public interface CarInfoService {
    boolean savecarinfo(CarInfo carInfo);
    boolean updatecarinfo(CarInfo carInfo);
    CarInfo getonecarinfobycarid(Long id_car);
    boolean deletecarinfo(Long id_carinfo);
}
