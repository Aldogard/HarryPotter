package com.example.harrypotter.entity.magicalbeings.giants;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GurgTest {

    @Test
    public void testGurgConstructor(){
        Gurg gurg = new Gurg("Karkus", BigDecimal.valueOf(10), "Test and more than 10");

        assertNotNull(gurg);
        assertEquals("Karkus", gurg.getName());
        assertEquals(BigDecimal.valueOf(10), gurg.getHealthPoints());
        assertEquals("Test and more than 10", gurg.getDescription());

        assertEquals("Gurg", gurg.getKlasse());
        assertEquals(BigDecimal.valueOf(0.5), gurg.getFaktor());
        assertEquals(100, gurg.getStunnedProtection());
        assertEquals(10, gurg.getIntelligence());
    }
}
