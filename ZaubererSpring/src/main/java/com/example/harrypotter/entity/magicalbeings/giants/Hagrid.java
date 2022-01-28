package com.example.harrypotter.entity.magicalbeings.giants;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "hagrid")
@DiscriminatorValue("hagrid")
public class Hagrid extends Giant {

    public Hagrid(String name, BigDecimal healthPoints, String description){
        super(name, healthPoints, description);
        this.setKlasse("Hagrid");
        this.setFaktor(BigDecimal.valueOf(0.75));
        this.setStunnedProtection(10);
        this.setIntelligence(30);



    }

    public Hagrid(){

    }

}
