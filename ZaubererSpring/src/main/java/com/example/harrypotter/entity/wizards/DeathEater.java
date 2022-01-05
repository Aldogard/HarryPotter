package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "deatheater")
@DiscriminatorValue("deatheater")
public class DeathEater extends Wizard {

    /**
     * Constructor for a wizard of the class DeathEater.
     * The Factor is set to 1.25.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public DeathEater(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("DeathEater");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }

    public DeathEater() {

    }
}