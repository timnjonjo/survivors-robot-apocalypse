package com.timnjonjo.robotapocalypse.models;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
@ToString
public class RobotData {
    private String model;
    private String serialNumber;
    private Date manufacturedDate;
    private String category;
}
