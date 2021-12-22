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

    @Column(name = "max_damage")
    private BigDecimal maxDamage;

    @Column(name = "description_option")
    private String descriptionOption;

    @Column(name = "required_experience")
    private Integer requiredExperience;

    @Column(name = "options_list")
    private static List<OptionEnum> optionsList = new ArrayList<>();


    public Options(String name,  Double maxDamage, String description, Integer requiredExperience) {
        this.name = name;
        this.maxDamage = BigDecimal.valueOf(maxDamage);
        this.descriptionOption = description;
        this.requiredExperience = requiredExperience;

    }

    public Options(){

    }
}
