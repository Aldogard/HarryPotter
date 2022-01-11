package com.example.harrypotter.entity.magicalbeings.wizards;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "sw")
public class StrengthAndWeakness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "house")
    private String house;

    @Column(name = "strength")
    private Boolean strength;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;

    /**
     * Each class has certain classes against which it is especially strong or weak.
     * The relations are created using this constructor.
     * @param house name of the class
     * @param strength indicates whether this class does well or bad against the other class.
     *                 True indicates strength, false weakness.
     * @param wizard indicates to which wizard the strengths and weaknesses belong.
     */

    public StrengthAndWeakness(String house, Boolean strength, Wizard wizard){
        this.house = house;
        this.strength = strength;
        this.wizard = wizard;
    }

    public StrengthAndWeakness() {

    }
}
