package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "dumbledore")
@DiscriminatorValue("dumbledore")
public class Dumbledore extends Wizard {

    public Dumbledore(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Dumbledore");
        this.setFaktor(BigDecimal.valueOf(2.0));
        setInternHealthPoints(healthPoints);

    }

    public Dumbledore() {

    }
}