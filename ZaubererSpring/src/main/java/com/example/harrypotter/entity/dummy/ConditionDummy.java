package com.example.harrypotter.entity.dummy;

import com.example.harrypotter.entity.dummy.Dummy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "zustand_dummy")
public class ConditionDummy {

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
    @JoinColumn(name = "dummy_id")
    private Dummy dummy;


    public ConditionDummy(Dummy dummy, String name){
        this.dummy = dummy;
        this.name = name;
        this.condition = false;
    }

    public ConditionDummy() {

    }

}
