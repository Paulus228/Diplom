package com.carshoptiger.util.exception;

import org.springframework.dao.DataAccessException;

public class OrderNotFountException extends DataAccessException {
    public OrderNotFountException(String msg) {
        super(msg);
    }

    public OrderNotFountException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
