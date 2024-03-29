package com.example.harrypotter.entity.magicalbeings.giants;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GiantTest {

    @Test
    public void testGiantConstructor(){
        Gurg gurg = new Gurg("Karkus", BigDecimal.valueOf(10), "Test and more than 10");

        assertNotNull(gurg);
        assertEquals("Karkus", gurg.getName());
        assertEquals(BigDecimal.valueOf(10), gurg.getHealthPoints());
        assertEquals("Test and more than 10", gurg.getDescription());
        assertEquals("Giant", gurg.getSpecies());

        assertEquals(0, gurg.getVictories());
        assertEquals(0, gurg.getAmount());
        assertEquals("Vernon Dursley", gurg.getRank());
        assertEquals(BigDecimal.valueOf(0.0), gurg.getRating());

        assertEquals(gurg.getEnergy(), gurg.getInternEnergy());
        assertEquals((gurg.getInternHealthPoints()), gurg.getHealthPoints());

    }
}
