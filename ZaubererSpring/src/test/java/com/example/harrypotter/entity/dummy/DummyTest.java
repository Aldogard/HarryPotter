package com.example.harrypotter.entity.dummy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {
    @Test
    public void testDummyConstructor(){
        Dummy test = new Dummy();
        assertNotNull(test);

        assertEquals("Dummy", test.getName());
        assertEquals(BigDecimal.valueOf(25), test.getHealthPoints());
        assertEquals("Test dummy for training purposes", test.getDescription());
        assertEquals(BigDecimal.valueOf(25.0), test.getEnergy());
        assertEquals(0, test.getStunnedProtection());
        assertEquals(0, test.getConfundedProtection());
        assertEquals(0, test.getPtCounter());
        assertEquals("Vernon Dursley", test.getRank());
        assertEquals(0, test.getAmount());
        assertEquals(0, test.getVictories());
        assertEquals(BigDecimal.valueOf(0.0), test.getVictoriesChess());

        assertEquals("Dummy", test.getKlasse());
        assertEquals("Dummy", test.getSpecies());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(0, test.getIntelligence());
        assertFalse(test.getHalfLife());
        assertFalse(test.getProtego());
        assertFalse(test.getFiendfyre());
    }
}
