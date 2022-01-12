package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.DeathEater;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DeathEaterTest {

    @Test
    public void testAlumniConstructor() {
        DeathEater test = new DeathEater("TestC", BigDecimal.valueOf(2), "dangerous");
        assertNotNull(test);
        assertEquals("TestC", test.getName());
        assertEquals(BigDecimal.valueOf(2), test.getHealthPoints());
        assertEquals("dangerous", test.getDescription());
        assertEquals("DeathEater", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}

