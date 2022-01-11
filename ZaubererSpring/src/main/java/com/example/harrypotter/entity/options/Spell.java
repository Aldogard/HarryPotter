package com.example.harrypotter.entity.options;


import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
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
     * Constructor that creates a spell.
     * @param name name of the spell
     * @param energyUsage indicates the energy required use a spell
     * @param maxDamage maximum amount of damage this wizard can inflict
     * @param healing amount of healing that can be achieved by using a spell
     * @param stunned indicates whether a spell can stun an opponent
     * @param confunded indicates whether a spell can confound an opponent
     * @param imperio indicates whether a spell can control an opponent
     * @param crucio indicates whether a spell can torture an opponent
     * @param protego indicates whether a spell can protect a wizard
     * @param fiendfyre indicates whether the spell casts a Fiendfyre
     * @param antiFiendfyre indicates whether a spell stops a Fiendfyre
     * @param requiredExperience some spells can only be used after a wizard acquired a certain amount of experience
     * @param wizard indicates to which wizard this spell belongs
     * @param description description about the effects of the spell
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

