package com.example.harrypotter.entity.magicalbeings.giants;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "half_giant")
@DiscriminatorValue("half_giant")
public class HalfGiant extends Giant {

    public HalfGiant(String name, BigDecimal healthPoints, String description){
        super(name, healthPoints, description);
        this.setKlasse("Half Giant");
        this.setFaktor(BigDecimal.valueOf(0.75));
        this.setStunnedProtection(10);
        this.setIntelligence(30);



    }

    public HalfGiant(){

    }

}
