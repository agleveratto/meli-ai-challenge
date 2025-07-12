package com.agl.meli.seller.exceptions;

import com.agl.meli.common.exceptions.JsonFileNotFoundException;
import com.agl.meli.common.exceptions.JsonFileParseException;
import com.agl.meli.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleSellerNotFoundException(SellerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler( JsonFileNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleJsonFileNotFoundException(JsonFileNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler( JsonFileParseException.class)
    public ResponseEntity<ApiResponse<Void>> handleJsonFileParseException(JsonFileParseException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(ex.getMessage()));
    }
}
