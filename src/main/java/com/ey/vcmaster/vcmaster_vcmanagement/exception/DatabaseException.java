package com.ey.vcmaster.vcmaster_vcmanagement.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message,Throwable cause) {
        super(message,cause);
    }
}
