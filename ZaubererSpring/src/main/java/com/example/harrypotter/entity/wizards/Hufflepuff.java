package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "hufflepuff")
@DiscriminatorValue("hufflepuff")
public class Hufflepuff extends Wizard {

    public Hufflepuff(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Hufflepuff");
        this.setFaktor(BigDecimal.valueOf(1.1));
        setInternHealthPoints(healthPoints);

    }

    public Hufflepuff() {

    }
}
