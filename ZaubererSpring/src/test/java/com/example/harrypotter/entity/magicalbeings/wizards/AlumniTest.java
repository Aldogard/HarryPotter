package com.example.harrypotter.entity.magicalbeings.wizards;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlumniTest {

    @Test
    public void testAlumniConstructor() {
        Alumni test = new Alumni("TestA", BigDecimal.valueOf(1), "old");
        assertNotNull(test);
        assertEquals("TestA", test.getName());
        assertEquals(BigDecimal.valueOf(1), test.getHealthPoints());
        assertEquals("old", test.getDescription());
        assertEquals("Alumni", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.2), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(55, test.getIntelligence());
    }
}
