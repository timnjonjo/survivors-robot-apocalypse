package com.timnjonjo.robotapocalypse.models;

import lombok.Data;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
public class SurvivorsSummary {
    private Integer totalSurvivors;
    private Double infectedSurvivors;
    private Double nonInfectedSurvivors;
}
