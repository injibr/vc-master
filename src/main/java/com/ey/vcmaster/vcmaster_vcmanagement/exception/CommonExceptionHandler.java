package com.ey.vcmaster.vcmaster_vcmanagement.exception;

import com.ey.vcmaster.vcmaster_vcmanagement.response.ApiResponse;
import com.ey.vcmaster.vcmaster_vcmanagement.response.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = {VcMasterException.class})
    public ResponseEntity<ApiResponse<String>> handleMissingParameterException(VcMasterException e) {
        return ResponseBuilder.error(HttpStatus.OK, e.getMessage(), null);
    }

    @ExceptionHandler(value = {NoResourceFoundException.class})
    public ResponseEntity<ApiResponse<String>> handleNoResourceFoundException(NoResourceFoundException e) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Not Found", null);
    }

    @ExceptionHandler(value = {DatabaseException.class})
    public ResponseEntity<ApiResponse<String>> handleVcDocumentException(DatabaseException e) {
        return ResponseBuilder.error(HttpStatus.OK, e.getMessage(), null);
    }

}
