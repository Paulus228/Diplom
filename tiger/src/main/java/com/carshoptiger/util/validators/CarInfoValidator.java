package com.carshoptiger.util.validators;

import com.carshoptiger.domain.CarInfo;

public class CarInfoValidator {
    public static boolean CarInfoValidation(CarInfo carInfo){
        return (!carInfo.getType().isEmpty() && carInfo.getType().length()>=3 && carInfo.getType().length()<=35)
                &&(!carInfo.getMake().isEmpty() && carInfo.getMake().length()>=3 && carInfo.getMake().length()<=35)
                &&(!carInfo.getModel().isEmpty() && carInfo.getModel().length()>=5 && carInfo.getModel().length()<=50)
                &&(carInfo.getMileage()>0 && carInfo.getMileage()<=250000)
                &&(!carInfo.getFuel().isEmpty() && carInfo.getFuel().length()>=5 && carInfo.getFuel().length()<=25)
                &&(carInfo.getEnginesize()>0 && carInfo.getEnginesize()<5000)
                &&(carInfo.getPower()>0 && carInfo.getPower()<=1000)
                &&(!carInfo.getGearbox().isEmpty() && carInfo.getGearbox().length()>=5 && carInfo.getGearbox().length()<=45)
                &&(carInfo.getNumberseat()>3 && carInfo.getNumberseat()<10)
                &&(!carInfo.getColor().isEmpty() && carInfo.getColor().length()>=5 && carInfo.getColor().length()<=45);
    }
}
