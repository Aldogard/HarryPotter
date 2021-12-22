package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "deatheater")
@DiscriminatorValue("deatheater")
public class DeathEater extends Wizard {

    public DeathEater(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("DeathEater");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }

    public DeathEater() {

    }
}