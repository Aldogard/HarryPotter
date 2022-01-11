package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DumbledoreTest {
    @Test
    public void testDumbledoreConstructor(){
        Dumbledore test = new Dumbledore("TestD", BigDecimal.valueOf(3), "Good");
        assertNotNull(test);
        assertEquals("TestD", test.getName());
        assertEquals(BigDecimal.valueOf(3), test.getHealthPoints());
        assertEquals("Good", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals(BigDecimal.valueOf(2.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
