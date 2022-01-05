package com.example.harrypotter.entity.options;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@MappedSuperclass
@Table(name = "optionen")
public abstract class Options {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "option_name")
    private String name;

    @Column(name = "healing")
    private BigDecimal healing;

    @Column(name = "max_damage")
    private BigDecimal maxDamage;

    @Column(name = "description_option")
    private String descriptionOption;

    @Column(name = "required_experience")
    private Integer requiredExperience;

    /**
     * Constructor that creates an option.
     * Each wizard will have certain options that he or she can use.
     * Since the option class is abstract, options can only be created in the subclasses.
     * @param name name of the option
     * @param maxDamage maximum amount of damage this option can inflict
     * @param description description about the effects of the option
     * @param requiredExperience some options can only be used after a wizard acquired a certain amount of experience
     * @param healing amount of healing an option can bring
     */


    public Options(String name,  Double maxDamage, String description, Integer requiredExperience, Double healing) {
        this.name = name;
        this.maxDamage = BigDecimal.valueOf(maxDamage);
        this.descriptionOption = description;
        this.requiredExperience = requiredExperience;
        this.healing = BigDecimal.valueOf(healing);

    }

    public Options(){

    }
}
