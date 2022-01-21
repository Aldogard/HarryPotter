package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "gryffindor")
@DiscriminatorValue("gryffindor")
public class  Gryffindor extends Wizard {

    /**
     * Constructor for a wizard of the class Gryffindor.
     * The Factor is set to 1.0.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Gryffindor(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Gryffindor");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);
        this.setIntelligence(45);


    }

    public Gryffindor() {

    }
}
