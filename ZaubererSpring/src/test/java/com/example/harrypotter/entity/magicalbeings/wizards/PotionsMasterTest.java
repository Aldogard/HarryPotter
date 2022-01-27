package com.example.harrypotter.entity.magicalbeings.wizards;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PotionsMasterTest {
    @Test
    public void testPotionsMasterConstructor(){
        PotionsMaster test = new PotionsMaster("TestPm", BigDecimal.valueOf(8), "Skilled");
        assertNotNull(test);
        assertEquals("TestPm", test.getName());
        assertEquals(BigDecimal.valueOf(8), test.getHealthPoints());
        assertEquals("Skilled", test.getDescription());
        assertEquals("Potions Master", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(60, test.getIntelligence());
    }
}
