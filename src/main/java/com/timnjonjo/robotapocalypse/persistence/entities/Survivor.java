package com.timnjonjo.robotapocalypse.persistence.entities;

import com.timnjonjo.robotapocalypse.models.SurvivorData;
import com.timnjonjo.robotapocalypse.models.SurvivorResourceData;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */

@Entity
public class Survivor extends Auditable {
    private String fullname;
    private String gender;
    private String nationalId;
    private boolean infected = false;
    private int contaminationReportCount = 0;
    @Embedded
    private Location lastLocation;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SurvivorResource> resources;

    public Survivor() {
    }


    public SurvivorData transform() {
        return new SurvivorData(this.fullname,
                this.gender,
                this.nationalId,
                this.lastLocation, this.infected);
    }

    public Survivor(String fullname, String gender, String nationalId, Location lastLocation) {
        this.fullname = fullname;
        this.gender = gender;
        this.nationalId = nationalId;
        this.lastLocation = lastLocation;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Integer getContaminationReportCount() {
        return contaminationReportCount;
    }

    public void setContaminationReportCount(Integer contaminationReportCount) {
        this.contaminationReportCount = contaminationReportCount;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location location) {
        this.lastLocation = location;
    }

    public List<SurvivorResource> getResources() {
        return resources;
    }

    public void setResources(List<SurvivorResource> resources) {
        this.resources = resources;
    }

    public boolean isInfected() {
        return this.contaminationReportCount >= 3;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public void updateLocation(Location location) {
        if (location == null) return;
        this.lastLocation = location;
    }


    public void flag() {
        this.contaminationReportCount++;
        if (this.contaminationReportCount >= 3) this.infected = true;
    }

    public void addResource(final SurvivorResourceData resource) {
        if (this.resources == null || this.resources.isEmpty()) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(new SurvivorResource(this, resource));
    }
}
