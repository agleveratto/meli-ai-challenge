package com.agl.meli.exceptions;

public class JsonFileNotFoundException extends RuntimeException {
    public JsonFileNotFoundException(String message) {
        super(message);
    }
}
