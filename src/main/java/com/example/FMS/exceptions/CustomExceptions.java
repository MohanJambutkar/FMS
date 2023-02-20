package com.example.FMS.exceptions;

import javax.persistence.PersistenceException;

public class CustomExceptions extends PersistenceException {
    public CustomExceptions(String message) {
        super(message);
    }
}
