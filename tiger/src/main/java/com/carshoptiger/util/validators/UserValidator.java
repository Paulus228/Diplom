package com.carshoptiger.util.validators;

import com.carshoptiger.domain.User;

public class UserValidator {
    public static boolean UserValidation(User user){
        return (!user.getUsername().isEmpty() && user.getUsername().length() >= 5 && user.getUsername().length() <= 80)
                && (!user.getName().isEmpty() && user.getName().length() >= 5 && user.getName().length() <= 100)
                && (!user.getSoname().isEmpty() && user.getSoname().length() >= 5 && user.getSoname().length() <= 100)
                && (!user.getPassword().isEmpty() && user.getPassword().length() >= 8 && user.getPassword().length() <= 40);
    }
}
