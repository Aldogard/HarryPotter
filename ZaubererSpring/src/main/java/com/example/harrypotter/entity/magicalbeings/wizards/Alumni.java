package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "alumni")
@DiscriminatorValue("alumni")
public class Alumni extends Wizard {

    /**
     * Constructor for a wizard of the class Alumni.
     * The Factor is set to 1.2.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Alumni(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Alumni");
        this.setFaktor(BigDecimal.valueOf(1.2));
        setInternHealthPoints(healthPoints);
        this.setIntelligence(55);


    }

    public Alumni() {

    }
}
