package com.agl.meli.utils;

import com.agl.meli.exceptions.JsonFileNotFoundException;
import com.agl.meli.exceptions.JsonFileParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonFileLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T loadFromJson(String fileName, TypeReference<T> typeReference) {
        InputStream inputStream = JsonFileLoader.class.getResourceAsStream("/%s".formatted(fileName));
        if (inputStream == null) {
            throw new JsonFileNotFoundException("Archivo no encontrado: %s".formatted(fileName));
        }

        try {
            return mapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            throw new JsonFileParseException("Error al leer archivo JSON: %s".formatted(fileName));
        }
    }
}