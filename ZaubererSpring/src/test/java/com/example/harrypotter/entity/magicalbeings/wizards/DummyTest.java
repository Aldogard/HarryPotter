package com.example.harrypotter.entity.magicalbeings.wizards;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DummyTest {
    @Test
    public void testDummyConstructor(){
        Dummy test = new Dummy("TestDummy", BigDecimal.valueOf(10), "Good and more than 10");
        assertNotNull(test);
        assertEquals("TestDummy", test.getName());
        assertEquals(BigDecimal.valueOf(10), test.getHealthPoints());
        assertEquals("Good and more than 10", test.getDescription());
        assertEquals("Dummy", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(0, test.getIntelligence());
    }
}
