package com.example.harrypotter.entity.wizards;

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
public abstract class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "wizard_name")
    private String name;

    @PositiveOrZero
    @DecimalMin("0.0")
    @DecimalMax("1000.0")
    @Column(name = "health_points")
    private BigDecimal healthPoints;

    @Column(name = "faktor")
    private BigDecimal faktor;

    @Column(name = "zauberer_energy")
    private BigDecimal energy;

    @Column(name = "additional_factor")
    private BigDecimal additionalFactor;

    @Column(name = "klasse")
    private String klasse;

    private final BigDecimal internEnergy = BigDecimal.valueOf(25.0);
    private BigDecimal internHealthPoints;

    @Column(name = "half_life")
    private Boolean halfLife;

    @Column(name = "stunned_protection")
    private Integer stunnedProtection;

    @Column(name = "confunded_protection")
    private Integer confundedProtection;

    @Column(name = "protego")
    private Boolean protego;

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

    @Size(max = 100)
    @Column(name ="description")
    private String description;


    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Condition> conditions;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Spell> spells;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Potion> potions;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StrengthAndWeakness> strengthAndWeaknesses;

    @JsonManagedReference
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animals;



    /**
     * Konstruktur zur Erstellung eines Zauberers
     *
     */

    public Wizard(String name, BigDecimal healthPoints, String description) {
        this.id = null;
        this.name= name;
        this.healthPoints = healthPoints;
        this.description = description;
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
        this.rank = "Dursley";
        this.rating = BigDecimal.valueOf(0.0);

    }

    public Wizard() {

    }

}

