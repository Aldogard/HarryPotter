package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Wizard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "potion")
public class Potion extends Options{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "storage")
    private Integer storage;

    @Column(name = "max_healing")
    private BigDecimal healing;

    @Column(name = "energy_restorage")
    private BigDecimal energyRestorage;

    @Column(name = "anti_paralysis")
    private Boolean antiParalysis;

    @Column(name = "anti_confunded")
    private Boolean antiConfunded;

    @Column(name = "regeneration")
    private Boolean regeneration;

    @Column(name = "unicorn_blood")
    private Boolean unicornBlood;

    @Column(name = "additional_factor")
    private BigDecimal additionalFactor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;

    public Potion(
            String name,
            Integer storage,
            Double healing,
            Double er,
            Boolean antiParalysis,
            Boolean antiConfunded,
            Boolean regeneration,
            Boolean unicornBlood,
            Double maxDamage,
            Double additionalFactor,
            Integer requiredExperience,
            Wizard wizard,
            String description) {

        super(name, maxDamage, description, requiredExperience);
        this.storage = storage;
        this.healing = BigDecimal.valueOf(healing);
        this.energyRestorage = BigDecimal.valueOf(er);
        this.antiParalysis = antiParalysis;
        this.antiConfunded = antiConfunded;
        this.regeneration = regeneration;
        this.unicornBlood = unicornBlood;
        this.additionalFactor = BigDecimal.valueOf(additionalFactor);
        this.wizard = wizard;

    }


    public Potion() {

    }

}








