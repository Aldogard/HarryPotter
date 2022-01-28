package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "melee")
public class Melee extends Options{

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magicalBeing_id")
    private MagicalBeing magicalBeing;

    public Melee(
            String name,
            Double energyUsage,
            Double maxDamage,
            Integer requiredExperience,
            Boolean stunned,
            Boolean confunded,
            MagicalBeing magicalBeing,
            String description
    ){
        super(name, maxDamage, description, requiredExperience, 0.0);
        this.energyUsage = BigDecimal.valueOf(energyUsage);
        this.confunded = confunded;
        this.stunned = stunned;
        this.magicalBeing = magicalBeing;

    }

    public Melee(){

    }
}
