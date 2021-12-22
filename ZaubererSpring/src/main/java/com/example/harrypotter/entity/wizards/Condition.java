package com.example.harrypotter.entity.wizards;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    

    public Condition(Wizard wizard, String condition){
        this.wizard = wizard;
        this.name = condition;
        this.condition = false;
    }



    public Condition() {

    }

}

