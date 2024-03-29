package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "wizard")
public abstract class Wizard extends MagicalBeing {

    /**
     * Constructor that creates a wizard.
     * Only the name, health-points and description can be chosen. All other values are predetermined.
     * Since the wizard class is abstract, wizard can only be created in the subclasses.
     *
     * @param name         name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description  a brief description of the wizard (max 100 characters)
     */

    public Wizard(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description, "Wizard");
    }

    public Wizard() {

    }

}

