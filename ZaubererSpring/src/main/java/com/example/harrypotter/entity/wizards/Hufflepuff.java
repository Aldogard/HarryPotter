package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "hufflepuff")
@DiscriminatorValue("hufflepuff")
public class Hufflepuff extends Wizard {

    /**
     * Loyal, patient, fair.
     * Constructor for a wizard of the class Hufflepuff.
     * The Factor is set to 1.1 (the highest factor of the four Hogwarts houses).
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Hufflepuff(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Hufflepuff");
        this.setFaktor(BigDecimal.valueOf(1.1));
        setInternHealthPoints(healthPoints);

    }

    public Hufflepuff() {

    }
}
