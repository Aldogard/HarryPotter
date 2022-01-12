package com.example.harrypotter.entity.magicalbeings.giants;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GiantTest {

    @Test
    public void testGiantConstructor(){
        Giant giant = new Giant("Rubeus", BigDecimal.valueOf(10), "Test and more than 10");

        assertNotNull(giant);
        assertEquals("Rubeus", giant.getName());
        assertEquals(BigDecimal.valueOf(10), giant.getHealthPoints());
        assertEquals("Test and more than 10", giant.getDescription());
        assertEquals("Giant", giant.getSpecies());

        assertEquals(0, giant.getVictories());
        assertEquals(0, giant.getAmount());
        assertEquals("Vernon Dursley", giant.getRank());
        assertEquals(BigDecimal.valueOf(0.0), giant.getRating());

        assertEquals(giant.getEnergy(), giant.getInternEnergy());
        assertEquals("Giant", giant.getKlasse());
        assertEquals((giant.getInternHealthPoints()), giant.getHealthPoints());
        assertEquals(100, giant.getStunnedProtection());

    }
}
