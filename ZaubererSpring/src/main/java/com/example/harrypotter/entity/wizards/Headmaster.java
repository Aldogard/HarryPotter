package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "headmaster")
@DiscriminatorValue("headmaster")
public class Headmaster extends Wizard {

    public Headmaster(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Headmaster");
        this.setFaktor(BigDecimal.valueOf(1.25));
        setInternHealthPoints(healthPoints);

    }


    public Headmaster() {

    }
}
