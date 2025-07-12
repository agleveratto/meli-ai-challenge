package com.agl.meli.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.Instant;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final String status;
    private final T data;
    private final String message;
    private final Instant timestamp;

    private ApiResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>( Status.SUCCESS.name(), data, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>( Status.ERROR.name(), null, message);
    }

    protected enum Status {
        SUCCESS, ERROR
    }
}