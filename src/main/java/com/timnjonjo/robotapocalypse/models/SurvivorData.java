package com.timnjonjo.robotapocalypse.models;

import com.timnjonjo.robotapocalypse.persistence.entities.Location;
import com.timnjonjo.robotapocalypse.persistence.entities.Survivor;
import com.timnjonjo.robotapocalypse.utils.validators.ValidEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class SurvivorData {
    @NotBlank(message = "Name Cannot Be null or empty")
    private String fullname;
    @ValidEnum(enumClass = Gender.class)
    private String gender;
    @NotBlank(message = "National ID Cannot Be null or empty")
    private String nationalId;
    @NotNull(message = "Location Cannot Be null")
    private Location lastLocation;
    private List<SurvivorResourceData> resources;
    private boolean infected;

    public SurvivorData() {
    }

    public SurvivorData(String fullname, String gender, String nationalId, Location lastLocation, boolean infected) {
        this.fullname = fullname;
        this.gender = gender;
        this.nationalId = nationalId;
        this.lastLocation = lastLocation;
        this.infected = infected;
    }

    public Survivor transform() {
        Survivor survivor = new Survivor(
                this.fullname,
                this.gender,
                this.nationalId,
                this.lastLocation);
        if (!this.resources.isEmpty()) this.resources.forEach(survivor::addResource);
        return survivor;
    }
}
