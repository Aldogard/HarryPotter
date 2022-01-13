package com.example.harrypotter.entity.magicalbeings;


import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
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
    @JoinColumn(name = "magicalBeing_id")
    private MagicalBeing magicalBeing;

    /**
     * Each class has certain classes against which it is especially strong or weak.
     * The relations are created using this constructor.
     * @param house name of the class
     * @param strength indicates whether this class does well or bad against the other class.
     *                 True indicates strength, false weakness.
     * @param magicalBeings indicates to which wizard the strengths and weaknesses belong.
     */

    public StrengthAndWeakness(String house, Boolean strength, Wizard magicalBeings){
        this.house = house;
        this.strength = strength;
        this.magicalBeing = magicalBeings;
    }

    public StrengthAndWeakness() {

    }
}
