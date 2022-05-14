package com.carshoptiger.util.exception;

import org.springframework.dao.EmptyResultDataAccessException;

public class UserNotFoundException extends EmptyResultDataAccessException {
    public UserNotFoundException(String message) {
        super(0);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, 0);
    }


}
