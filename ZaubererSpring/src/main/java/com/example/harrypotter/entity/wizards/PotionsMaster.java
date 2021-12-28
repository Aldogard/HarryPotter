package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "potions_master")
@DiscriminatorValue("potions_master")
public class PotionsMaster extends Wizard {

    public PotionsMaster(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Potionsmaster");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }

    public PotionsMaster() {

    }
}