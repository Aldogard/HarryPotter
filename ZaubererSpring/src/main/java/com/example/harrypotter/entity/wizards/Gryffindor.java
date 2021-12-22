package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "gryffindor")
@DiscriminatorValue("gryffindor")
public class Gryffindor extends Wizard {

    public Gryffindor(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Gryffindor");
        this.setFaktor(BigDecimal.valueOf(1.0));
        setInternHealthPoints(healthPoints);

    }

    public Gryffindor() {

    }
}
