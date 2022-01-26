package com.example.harrypotter.entity.options;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String ingredient;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "potion_id")
    private Potion potion;

    public Ingredient(String ingredient, Potion potion){
        this.ingredient = ingredient;
        this.potion = potion;
    }

    public Ingredient(){

    }

}
