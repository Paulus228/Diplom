package com.carshoptiger.util.validators;

import com.carshoptiger.domain.CarPhoto;

public class CarPhotoValidator {
    public static boolean CarPhotoValidation(CarPhoto carPhoto){
        return (!carPhoto.getPhotourl().isEmpty() && carPhoto.getPhotourl().length()>=35 && carPhoto.getPhotourl().length()<=255);
    }
}
