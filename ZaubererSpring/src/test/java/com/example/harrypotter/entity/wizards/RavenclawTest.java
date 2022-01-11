package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Ravenclaw;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RavenclawTest {
    @Test
    public void testRavenclawConstructor(){
        Ravenclaw test = new Ravenclaw("TestR", BigDecimal.valueOf(10), "Clever");
        assertNotNull(test);
        assertEquals("TestR", test.getName());
        assertEquals(BigDecimal.valueOf(10), test.getHealthPoints());
        assertEquals("Clever", test.getDescription());
        assertEquals("Ravenclaw", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
