package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Data
@Entity(name = "voldemort")
@DiscriminatorValue("voldemort")
public class Voldemort extends Wizard {

    public Voldemort(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Voldemort");
        this.setFaktor(BigDecimal.valueOf(1.5));
        setInternHealthPoints(healthPoints);

    }


    public Voldemort() {

    }
}