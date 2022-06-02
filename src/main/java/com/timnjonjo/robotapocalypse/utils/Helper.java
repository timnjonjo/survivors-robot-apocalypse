package com.timnjonjo.robotapocalypse.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Slf4j
public class Helper {

    public static ObjectMapper objectMapper(){
        //TODO:  Configure Object mapper before returning
        return new ObjectMapper();
    }

    public static <T> List<T> readObjectList(String data, Class<T> responseType) {
        if (data == null || data.isEmpty()) return new ArrayList<>();
        CollectionType listType = objectMapper().getTypeFactory().constructCollectionType(ArrayList.class, responseType);
        try {
            return objectMapper().readValue(data, listType);
        } catch (JsonProcessingException e) {
            log.error("error={}", e.getMessage());
        }
        return new ArrayList<>();

    }
}
