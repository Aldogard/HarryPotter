package com.example.harrypotter.entity.magicalbeings.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "dummy")
@DiscriminatorValue("dummy")
public class Dummy extends Wizard{


    public Dummy(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Dummy");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);
        this.setIntelligence(0);


    }

    public Dummy() {

    }
}
