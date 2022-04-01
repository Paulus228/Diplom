package com.carshoptiger.util.exception;

import org.springframework.dao.DataAccessException;

public class UserNotFound extends DataAccessException {
    public UserNotFound(String message) {
        super(message);
    }

    public UserNotFound(String message, Throwable cause) {
        super(message, cause);
    }


}
