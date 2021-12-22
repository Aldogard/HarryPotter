package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "slytherin")
@DiscriminatorValue("slytherin")
public class Slytherin extends Wizard {

    public Slytherin(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Slytherin");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);

    }

    public Slytherin() {

    }
}
