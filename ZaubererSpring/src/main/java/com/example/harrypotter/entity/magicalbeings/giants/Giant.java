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


    @Column(name = "mb_energy")
    private BigDecimal energy;

    @Column(name = "klasse")
    private String klasse;

    private final BigDecimal internEnergy = BigDecimal.valueOf(25.0);
    private BigDecimal internHealthPoints;

    /**
     * Indicates whether the giant is protected against a stunning spell.
     */

    @Column(name = "stunned_protection")
    private Integer stunnedProtection;

    public Giant(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description, "Giant");
        this.energy = internEnergy;
        this.internHealthPoints = healthPoints;
    }


    public Giant() {


    }
}
