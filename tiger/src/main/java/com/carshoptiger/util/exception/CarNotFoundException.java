package com.carshoptiger.util.exception;

import org.springframework.dao.DataAccessException;

public class CarNotFoundException extends DataAccessException {
    public CarNotFoundException(String msg) {
        super(msg);
    }

    public CarNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
