package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Headmaster;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HeadmasterTest {
    @Test
    public void testHeadmasterConstructor(){
        Headmaster test = new Headmaster("TestHm", BigDecimal.valueOf(6), "Leader");
        assertNotNull(test);
        assertEquals("TestHm", test.getName());
        assertEquals(BigDecimal.valueOf(6), test.getHealthPoints());
        assertEquals("Leader", test.getDescription());
        assertEquals("Headmaster", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
