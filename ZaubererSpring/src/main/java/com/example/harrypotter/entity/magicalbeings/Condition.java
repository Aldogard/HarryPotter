package com.example.harrypotter.entity.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "zustand")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "zustand_name")
    private String name;

    @Column(name = "zustand")
    private Boolean condition;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private MagicalBeing magicalBeing;

    /**
     * Each wizard has conditions that can be either true or false.
     * All conditions are initially not met (false)
     * @param magicalBeing indicates to which wizard the conditions belongs
     * @param name name of the condition
     */

    public Condition(MagicalBeing magicalBeing, String name){
        this.magicalBeing = magicalBeing;
        this.name = name;
        this.condition = false;
    }



    public Condition() {

    }

}

