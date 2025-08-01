package com.ey.vcmaster.vcmaster_vcmanagement.exception;

public class VcMasterException extends RuntimeException {
    public VcMasterException(String message) {
        super(message);
    }

    public VcMasterException(String message, Throwable cause) {
        super(message, cause);
    }
}
