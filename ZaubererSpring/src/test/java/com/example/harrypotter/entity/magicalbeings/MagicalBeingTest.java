package com.example.harrypotter.entity.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicalBeingTest {

    @Test
    public void testMagicalBeingConstructor(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral and more than 10");

        assertNotNull(test);
        assertEquals("TestW", test.getName());
        assertEquals(BigDecimal.valueOf(4), test.getHealthPoints());
        assertEquals("Neutral and more than 10", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals(BigDecimal.valueOf(2.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(BigDecimal.valueOf(25.0), test.getEnergy());
        assertEquals(test.getEnergy(), test.getInternEnergy());
        assertEquals(BigDecimal.valueOf(1.0), test.getAdditionalFactor());
        assertFalse(test.getHalfLife());
        assertEquals(0, test.getStunnedProtection());
        assertEquals(0, test.getConfundedProtection());
        assertFalse(test.getProtego());
        assertFalse(test.getFiendfyre());
        assertEquals(0, test.getPtCounter());
        assertEquals(0, test.getVictories());
        assertEquals(0, test.getAmount());
        assertEquals("Vernon Dursley", test.getRank());
        assertEquals(BigDecimal.valueOf(0.0), test.getRating());
    }
}
