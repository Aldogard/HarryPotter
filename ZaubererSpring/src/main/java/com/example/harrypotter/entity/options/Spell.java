package com.example.harrypotter.entity.options;


import com.example.harrypotter.entity.wizards.Wizard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "spell")
public class Spell extends Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "energy_usage")
    private BigDecimal energyUsage;

    @Column(name = "boolean_stunned")
    private Boolean stunned;

    @Column(name = "boolean_confunded")
    private Boolean confunded;

    @Column(name = "imperio")
    private Boolean imperio;

    @Column(name = "crucio")
    private Boolean crucio;

    @Column(name = "protego")
    private Boolean protego;

    @Column(name = "fiendfyre")
    private Boolean fiendfyre;

    @Column(name = "anti_fiendfyre")
    private Boolean antiFiendfyre;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;


    /**
     * Constructor to create a spell
     */

    public Spell(
            String name,
            Double energyUsage,
            Double maxDamage,
            Double healing,
            Boolean stunned,
            Boolean confunded,
            Boolean imperio,
            Boolean crucio,
            Boolean protego,
            Boolean fiendfyre,
            Boolean antiFiendfyre,
            Integer requiredExperience,
            Wizard wizard,
            String description) {

        super(name, maxDamage, description, requiredExperience, healing);
        this.energyUsage = BigDecimal.valueOf(energyUsage);
        this.stunned = stunned;
        this.confunded = confunded;
        this.imperio = imperio;
        this.crucio = crucio;
        this.protego = protego;
        this.fiendfyre = fiendfyre;
        this.antiFiendfyre = antiFiendfyre;
        this.wizard = wizard;
    }



    public Spell() {

    }


}

