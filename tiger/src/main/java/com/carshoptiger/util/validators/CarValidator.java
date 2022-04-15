package com.carshoptiger.util.validators;

import com.carshoptiger.domain.Car;

public class CarValidator {
    public static boolean CarValidation(Car carvalid){
        return (!carvalid.getName().isEmpty() && carvalid.getName().length() >= 4 && carvalid.getName().length() <= 255)
                && (!carvalid.getDescription().isEmpty() && carvalid.getDescription().length() >= 15 && carvalid.getDescription().length() <= 455)
                && (carvalid.getPrice() > 0 && carvalid.getPrice() <= 150000);
    }
}
