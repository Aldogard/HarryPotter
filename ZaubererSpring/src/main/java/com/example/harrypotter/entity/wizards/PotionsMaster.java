package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "potions_master")
@DiscriminatorValue("potions_master")
public class PotionsMaster extends Wizard {

    /**
     * Constructor for a wizard of the class Potions Master.
     * The Factor is set to 1.25.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public PotionsMaster(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Potions Master");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }

    public PotionsMaster() {

    }
}