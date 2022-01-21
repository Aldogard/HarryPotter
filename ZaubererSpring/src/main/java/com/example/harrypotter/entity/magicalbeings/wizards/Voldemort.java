package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Data
@Entity(name = "voldemort")
@DiscriminatorValue("voldemort")
public class Voldemort extends Wizard {

    /**
     * Constructor for a wizard of the class Voldemort.
     * The Factor is set to 1.5 (2nd highest factor of all classes).
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Voldemort(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Voldemort");
        this.setFaktor(BigDecimal.valueOf(1.5));
        setInternHealthPoints(healthPoints);
        this.setIntelligence(65);


    }


    public Voldemort() {

    }
}