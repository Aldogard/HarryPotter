package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.options.Potion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "wizard")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("wizard")

public abstract class Wizard extends MagicalBeing {

    /**
     * Each wizard has a factor by which his attack is multiplied.
     * Differs between different classes.
     */

    @Column(name = "faktor")
    private BigDecimal faktor;

    @Column(name = "zauberer_energy")
    private BigDecimal energy;

    @Column(name = "additional_factor")
    private BigDecimal additionalFactor;


    /**
     * Each wizard belongs to a class which brings certain advantages and disadvantages.
     */

    @Column(name = "klasse")
    private String klasse;

    /**
     * The initial energy of every wizard is 25.0.
     */

    private final BigDecimal internEnergy = BigDecimal.valueOf(25.0);
    private BigDecimal internHealthPoints;

    /**
     * Indicates whether the wizard use Unicorn Blood.
     */

    @Column(name = "half_life")
    private Boolean halfLife;

    /**
     * Indicates whether the wizard is protected against a stunning spell.
     */

    @Column(name = "stunned_protection")
    private Integer stunnedProtection;

    /**
     * Indicates whether the wizard is protected against a confounding spell.
     */

    @Column(name = "confunded_protection")
    private Integer confundedProtection;

    /**
     * Indicates whether a wizard used Protego.
     */
    @Column(name = "protego")
    private Boolean protego;

    /**
     * Indicates whether the wizard used Fiendfyre or not.
     */

    @Column(name = "fiendfyre")
    private Boolean fiendfyre;

    @Column(name = "pt_counter")
    private Integer ptCounter;

    @Column(name = "rank_name")
    private String rank;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "victories")
    private Integer victories;


    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Spell> spells;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Potion> potions;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StrengthAndWeakness> strengthAndWeaknesses;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animals;



    /**
     * Constructor that creates a wizard.
     * Only the name, health-points and description can be chosen. All other values are predetermined.
     * Since the wizard class is abstract, wizard can only be created in the subclasses.
     * @param name name of the wizards (mandatory)
     * @param healthPoints initial health-points of the wizard (between 1 and 100)
     * @param description a brief description of the wizard (max 100 characters)
     */

    public Wizard(String name, BigDecimal healthPoints, String description) {
        super(name, healthPoints, description, "Wizard");
        this.energy = internEnergy;
        this.additionalFactor = BigDecimal.valueOf(1.0);
        this.halfLife = false;
        this.stunnedProtection = 0;
        this.confundedProtection = 0;
        this.protego = false;
        this.fiendfyre = false;
        this.ptCounter = 0;
        this.victories = 0;
        this.amount = 0;
        this.rank = "Vernon Dursley";
        this.rating = BigDecimal.valueOf(0.0);

    }

    public Wizard() {

    }

}

