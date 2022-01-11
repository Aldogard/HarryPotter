package com.example.harrypotter.entity.magicalbeings;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "magical_being")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType= DiscriminatorType.STRING)
public abstract class MagicalBeing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "mb_name")
    private String name;

    @NotNull
    @DecimalMin("1.0")
    @DecimalMax("100.0")
    @Column(name = "health_points")
    private BigDecimal healthPoints;

    @NotNull
    @Size(min = 10, max = 100)
    @Column(name ="description")
    private String description;

    @Column(name = "species")
    private String species;

    @JsonManagedReference
    @OneToMany(mappedBy = "magicalBeing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;

    @JsonManagedReference
    @OneToMany(mappedBy = "magicalBeing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Condition> conditions;


    public MagicalBeing(String name, BigDecimal healthPoints, String description, String species) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.description = description;
        this.species = species;
    }

    public MagicalBeing(){

    }
}
