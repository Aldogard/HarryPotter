package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Voldemort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VoldemortTest {
    @Test
    public void testVoldemortConstructor(){
        Voldemort test = new Voldemort("TestV", BigDecimal.valueOf(12), "Dark");
        assertNotNull(test);
        assertEquals("TestV", test.getName());
        assertEquals(BigDecimal.valueOf(12), test.getHealthPoints());
        assertEquals("Dark", test.getDescription());
        assertEquals("Voldemort", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.5), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
