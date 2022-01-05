package com.example.harrypotter.entity.wizards;

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
    private Wizard wizard;

    /**
     * Each wizard has conditions that can be either true or false.
     * All conditions are initially not met (false)
     * @param wizard indicates to which wizard the conditions belongs
     * @param name name of the condition
     */

    public Condition(Wizard wizard, String name){
        this.wizard = wizard;
        this.name = name;
        this.condition = false;
    }



    public Condition() {

    }

}

