package com.timnjonjo.robotapocalypse.models;

import lombok.Builder;
import lombok.Data;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */

@Builder
@Data
public class SurvivorResourceData {
    private String name;
    private String quantity;
}
