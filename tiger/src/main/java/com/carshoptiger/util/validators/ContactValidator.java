package com.carshoptiger.util.validators;

import com.carshoptiger.domain.Contacts;

public class ContactValidator {
    public static boolean ContactValidation(Contacts contact){
        return (!contact.getFullname().isEmpty() && contact.getFullname().length() >= 10 && contact.getFullname().length() <= 120)
                && (!contact.getSubject().isEmpty() && contact.getSubject().length() >= 5 && contact.getSubject().length() <= 100)
                && (!contact.getMessage().isEmpty() && contact.getMessage().length() >= 20 && contact.getMessage().length() <= 255);

    }
}
