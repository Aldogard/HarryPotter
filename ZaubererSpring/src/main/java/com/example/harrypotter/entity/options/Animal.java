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
