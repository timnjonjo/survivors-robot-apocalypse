package com.timnjonjo.robotapocalypse.models;

import lombok.Data;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
