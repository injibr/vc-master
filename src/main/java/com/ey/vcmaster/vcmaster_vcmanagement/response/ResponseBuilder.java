package com.ey.vcmaster.vcmaster_vcmanagement.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(
                "success",
                HttpStatus.OK.value(),
                message,
                data
        );
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message, T data) {
        ApiResponse<T> response = new ApiResponse<>(
                "error",
                status.value(),
                message,
                data
        );
        return new ResponseEntity<>(response, status);
    }
}
