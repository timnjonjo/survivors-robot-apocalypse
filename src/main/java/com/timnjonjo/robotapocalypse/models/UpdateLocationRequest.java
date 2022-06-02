package com.timnjonjo.robotapocalypse.models;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
@ToString
public class UpdateLocationRequest {
    @NotNull(message = "Survivor Id Cannot be null")
    @Range(min = 1, message = "Survivor Id Cannot be negative.")
    private Long survivorId;
    @NotNull(message = "Latitude Cannot be null")
    @Range(min = -90, max = 90, message = "The valid range of latitude in degrees is -90 and +90.")
    private BigDecimal latitude;
    @NotNull(message = "Latitude Cannot be null.")
    @Range(min = -90, max = 90, message = "Longitude must be in the range -180 and +180.")
    private BigDecimal longitude;

    public UpdateLocationRequest() {
    }

    public UpdateLocationRequest(Long survivorId, BigDecimal latitude, BigDecimal longitude) {
        this.survivorId = survivorId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
