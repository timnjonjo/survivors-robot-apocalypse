package com.timnjonjo.robotapocalypse.persistence.entities;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Embeddable
public class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Location() {
    }

    public Location(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location: " + latitude + "," + latitude;
    }
}
