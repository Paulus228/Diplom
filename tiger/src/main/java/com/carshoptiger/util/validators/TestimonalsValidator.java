package com.carshoptiger.util.validators;

import com.carshoptiger.domain.Testimonals;

public class TestimonalsValidator {
    public static boolean TestimonalsValidation(Testimonals testimonalsValid){
        return (!testimonalsValid.getFullname().isEmpty() && testimonalsValid.getFullname().length() >= 10 && testimonalsValid.getFullname().length() <= 130)
                && (!testimonalsValid.getMessage_testimonals().isEmpty() && testimonalsValid.getMessage_testimonals().length() >= 20 && testimonalsValid.getMessage_testimonals().length() <= 255);
    }
}
