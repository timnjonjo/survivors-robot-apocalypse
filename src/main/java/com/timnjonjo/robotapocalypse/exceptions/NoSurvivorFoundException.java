package com.timnjonjo.robotapocalypse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSurvivorFoundException extends RuntimeException {
    public NoSurvivorFoundException(Long survivorId) {
        super("Survivor with Id:" + survivorId + " Not Found");
    }

    public NoSurvivorFoundException() {
        super("No Survivor(s) Found");
    }
}
