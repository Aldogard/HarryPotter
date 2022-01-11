package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "headmaster")
@DiscriminatorValue("headmaster")
public class Headmaster extends Wizard {

    /**
     * Constructor for a wizard of the class Headmaster.
     * The Factor is set to 1.25.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Headmaster(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Headmaster");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }


    public Headmaster() {

    }
}
