package com.example.harrypotter.entity.dummy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "dummy")
public class Dummy {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "mb_name")
    private String name;

    @NotNull
    @DecimalMin("1.0")
    @DecimalMax("100.0")
    @Column(name = "health_points")
    private BigDecimal healthPoints;

    @NotNull
    @Size(min = 10, max = 100)
    @Column(name = "description")
    private String description;

    @Column(name = "species")
    private String species;

    /**
     * Each being has a factor by which his attack is multiplied.
     * Differs between different classes.
     */

    @Column(name = "faktor")
    private BigDecimal faktor;

    @Column(name = "mb_energy")
    private BigDecimal energy;

    @Column(name = "additional_factor")
    private BigDecimal additionalFactor;


    /**
     * Each being belongs to a class which brings certain advantages and disadvantages.
     */

    @Column(name = "klasse")
    private String klasse;

    /**
     * The initial energy of every being is 25.0.
     */

    private final BigDecimal internEnergy = BigDecimal.valueOf(25.0);
    private BigDecimal internHealthPoints;

    /**
     * Indicates whether the being used Unicorn Blood.
     */

    @Column(name = "half_life")
    private Boolean halfLife;

    /**
     * Indicates whether the being is protected against a stunning spell.
     */

    @Column(name = "stunned_protection")
    private Integer stunnedProtection;

    /**
     * Indicates whether the being is protected against a confounding spell.
     */

    @Column(name = "confunded_protection")
    private Integer confundedProtection;

    /**
     * Indicates whether a being used Protego.
     */
    @Column(name = "protego")
    private Boolean protego;

    /**
     * Indicates whether the being used Fiendfyre or not.
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

    @Column(name = "victories_chess")
    private BigDecimal victoriesChess;

    @Column(name = "intelligence")
    private Integer intelligence;


    @JsonManagedReference
    @OneToMany(mappedBy = "dummy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConditionDummy> conditions;


    public Dummy() {
        this.name = "Dummy";
        this.healthPoints = BigDecimal.valueOf(25);
        this.description = "Test dummy for training purposes";
        this.species = species;
        this.victories = 0;
        this.victoriesChess = BigDecimal.valueOf(0.0);
        this.amount = 0;
        this.rank = "Vernon Dursley";
        this.rating = BigDecimal.valueOf(0.0);
        this.species = "Dummy";
        this.klasse = "Dummy";
        this.faktor = BigDecimal.valueOf(1.0);
        internHealthPoints = healthPoints;
        intelligence = 0;

        this.energy = internEnergy;
        this.additionalFactor = BigDecimal.valueOf(1.0);
        this.halfLife = false;
        this.stunnedProtection = 0;
        this.confundedProtection = 0;
        this.protego = false;
        this.fiendfyre = false;
        this.ptCounter = 0;
    }


}
