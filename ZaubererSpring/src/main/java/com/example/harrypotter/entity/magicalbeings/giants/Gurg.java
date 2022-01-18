package com.example.harrypotter.entity.magicalbeings.giants;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity(name = "gurg")
@DiscriminatorValue("gurg")
public class Gurg extends Giant {

    public Gurg(String name, BigDecimal healthPoints, String description){
        super(name, healthPoints, description);
        this.setKlasse("Gurg");
        this.setFaktor(BigDecimal.valueOf(0.5));
        this.setStunnedProtection(100);
    }

    public Gurg(){

    }

}
