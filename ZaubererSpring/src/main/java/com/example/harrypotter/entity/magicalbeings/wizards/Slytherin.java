package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "slytherin")
@DiscriminatorValue("slytherin")
public class Slytherin extends Wizard {

    /**
     * Constructor for a wizard of the class Slytherin.
     * The Factor is set to 1.0.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Slytherin(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Slytherin");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);
        this.setIntelligence(45);

    }

    public Slytherin() {

    }
}
