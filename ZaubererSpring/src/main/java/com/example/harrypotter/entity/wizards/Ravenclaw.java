package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "ravenclaw")
@DiscriminatorValue("ravenclaw")
public class Ravenclaw extends Wizard {

    public Ravenclaw(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Ravenclaw");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);

    }

    public Ravenclaw() {

    }
}
