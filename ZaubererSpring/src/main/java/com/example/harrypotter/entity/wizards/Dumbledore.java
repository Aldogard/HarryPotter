package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "dumbledore")
@DiscriminatorValue("dumbledore")
public class Dumbledore extends Wizard {

    /**
     * Constructor for a wizard of the class Dumbledore.
     * The Factor is set to 2.0 (the largest factor of all classes).
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Dumbledore(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Dumbledore");
        this.setFaktor(BigDecimal.valueOf(2.0));
        setInternHealthPoints(healthPoints);

    }

    public Dumbledore() {

    }
}