package com.example.harrypotter.entity.wizards;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeathEaterTest {
    @Test
    public void testDeathEaterConstructor(){
        DeathEater test = new DeathEater("TestDe", BigDecimal.valueOf(2), "Evil");
        assertNotNull(test);
        assertEquals("TestDe", test.getName());
        assertEquals(BigDecimal.valueOf(2), test.getHealthPoints());
        assertEquals("Evil", test.getDescription());
        assertEquals("DeathEater", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
