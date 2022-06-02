package com.timnjonjo.robotapocalypse.persistence.entities;

import com.timnjonjo.robotapocalypse.models.SurvivorResourceData;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */

@Entity
public class SurvivorResource extends Auditable {
    @ManyToOne()
    private Survivor survivor;
    private String name;
    private String quantity;

    public SurvivorResource() {
    }

    public  SurvivorResource(SurvivorResourceData resource){
        this.name = resource.getName();
        this.quantity = resource.getQuantity();
    }


    public SurvivorResource(Survivor survivor, SurvivorResourceData resource) {
        this(resource);
        this.survivor = survivor;
    }


    public Survivor getSurvivor() {
        return survivor;
    }

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
