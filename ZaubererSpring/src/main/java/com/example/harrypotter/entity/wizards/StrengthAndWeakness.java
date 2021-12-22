package com.example.harrypotter.entity.wizards;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "sw")
public class StrengthAndWeakness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "house")
    private String house;

    @Column(name = "strength")
    private Boolean strength;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;

    public StrengthAndWeakness(String house, Boolean strength, Wizard wizard){
        this.house = house;
        this.strength = strength;
        this.wizard = wizard;
    }

    public StrengthAndWeakness() {

    }
}
