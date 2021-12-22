package com.example.harrypotter.entity.wizards;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "alumni")
@DiscriminatorValue("alumni")
public class Alumni extends Wizard {

    public Alumni(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description);
        this.setKlasse("Alumni");
        this.setFaktor(BigDecimal.valueOf(1.2));
        setInternHealthPoints(healthPoints);

    }

    public Alumni() {

    }
}
