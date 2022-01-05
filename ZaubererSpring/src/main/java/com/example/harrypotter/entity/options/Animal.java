package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Wizard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "animal")
public class Animal extends Options{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "energy_usage")
    private BigDecimal energyUsage;

    @Column(name = "energy_recovery")
    private BigDecimal energyRecovery;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;


    /**
     * Constructor that creates an animal.
     * @param name name of the animal
     * @param energyUsage indicates the energy required to put an animal into action
     * @param maxDamage maximum amount of damage this animal can inflict
     * @param requiredExperience some animal can only be put into action after a wizard acquired a certain amount of experience
     * @param healing amount of healing that can be achieved by activating an animal
     * @param recovery amount of energy that can be recovered by activating an animal
     * @param wizard indicates to which wizard this animal belongs
     * @param description description about the effects of the animal
     */

    public Animal(
            String name,
            Double energyUsage,
            Double maxDamage,
            Integer requiredExperience,
            Double healing,
            Double recovery,
            Wizard wizard,
            String description
    ){
        super(name, maxDamage, description, requiredExperience, healing);
        this.energyUsage = BigDecimal.valueOf(energyUsage);
        this.energyRecovery = BigDecimal.valueOf(recovery);
        this.wizard = wizard;
    }



    public Animal(){

    }
}
