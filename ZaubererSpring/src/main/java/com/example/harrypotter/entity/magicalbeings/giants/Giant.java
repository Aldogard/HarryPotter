package com.example.harrypotter.entity.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "giant")
@DiscriminatorValue("giant")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING)

public abstract class Giant extends MagicalBeing {

    /**
     * Indicates whether the giant is protected against a stunning spell.
     */

    public Giant(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description, "Giant");
        this.setInternHealthPoints(healthPoints);
    }


    public Giant() {


    }
}
