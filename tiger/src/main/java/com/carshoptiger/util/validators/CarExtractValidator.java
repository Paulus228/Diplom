package com.carshoptiger.util.validators;

import com.carshoptiger.domain.CarExtract;

public class CarExtractValidator {
    public static boolean CarExtractValidation(CarExtract carExtract){
        return (!carExtract.getExtract().isEmpty() && carExtract.getExtract().length()>=10 && carExtract.getExtract().length()<=255);
    }
}
