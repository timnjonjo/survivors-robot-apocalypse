package com.timnjonjo.robotapocalypse.api;

import com.timnjonjo.robotapocalypse.exceptions.NoSurvivorFoundException;
import com.timnjonjo.robotapocalypse.models.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@RestControllerAdvice
public class RestExceptionHandlerController {

    @ExceptionHandler
    public ErrorResponse onNoSurvivorFoundException(NoSurvivorFoundException ex){
        return new ErrorResponse("ER0404", ex.getMessage());
    }
}
