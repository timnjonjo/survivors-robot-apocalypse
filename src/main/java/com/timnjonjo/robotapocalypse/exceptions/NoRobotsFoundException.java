package com.timnjonjo.robotapocalypse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRobotsFoundException extends RuntimeException {
    public NoRobotsFoundException() {
        super("No Robots Found from the Robots CPU");
    }
}
