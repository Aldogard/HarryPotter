package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "potion")
public class Potion extends Options{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "storage")
    private Integer storage;

    @Column(name = "energy_recovery")
    private BigDecimal energyRecovery;

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
    @JoinColumn(name = "magicalBeing_id")
    private MagicalBeing magicalBeing;

    @JsonManagedReference
    @OneToMany(mappedBy = "potion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredient;

    /**
     * Constructor that creates a potion.
     * @param name name of the potion
     * @param storage potions must be taken out of a wizard's storage. Storage indicates how often a wizards owns this potion
     * @param healing amount of healing that can be achieved by using a potion
     * @param recovery amount of energy that can be recovered by using a potion
     * @param antiParalysis indicates whether this potion protects against stunning spells
     * @param antiConfunded indicates whether this potion protects against confounding spells
     * @param regeneration indicates whether this potion is a regeneration potions
     * @param unicornBlood indicates whether this potion is unicorn blood
     * @param maxDamage maximum amount of damage this potion can inflict
     * @param additionalFactor some potions can increase the additional factor of a wizard
     * @param requiredExperience some potions can only be used after a wizard acquired a certain amount of experience
     * @param magicalBeing indicates to which magical being this potion belongs
     * @param description description about the effects of the potion
     */

    public Potion(
            String name,
            Integer storage,
            Double healing,
            Double recovery,
            Boolean antiParalysis,
            Boolean antiConfunded,
            Boolean regeneration,
            Boolean unicornBlood,
            Double maxDamage,
            Double additionalFactor,
            Integer requiredExperience,
            MagicalBeing magicalBeing,
            String description) {

        super(name, maxDamage, description, requiredExperience, healing);
        this.storage = storage;
        this.energyRecovery = BigDecimal.valueOf(recovery);
        this.antiParalysis = antiParalysis;
        this.antiConfunded = antiConfunded;
        this.regeneration = regeneration;
        this.unicornBlood = unicornBlood;
        this.additionalFactor = BigDecimal.valueOf(additionalFactor);
        this.magicalBeing = magicalBeing;

    }


    public Potion() {

    }

}








