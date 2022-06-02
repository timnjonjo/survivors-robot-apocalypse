package com.timnjonjo.robotapocalypse.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
public class FlagSurvivorRequest {
    @NotNull(message = "Survivor Id Cannot be null")
    @Range(min = 1, message = "Survivor Id Cannot be negative")
    private Long survivorId;

    public FlagSurvivorRequest() {
    }

    public FlagSurvivorRequest(Long survivorId) {
        this.survivorId = survivorId;
    }
}
