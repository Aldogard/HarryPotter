package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Slytherin;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SlytherinTest {
    @Test
    public void testSlytherinConstructor(){
        Slytherin test = new Slytherin("TestS", BigDecimal.valueOf(11), "Ambitious");
        assertNotNull(test);
        assertEquals("TestS", test.getName());
        assertEquals(BigDecimal.valueOf(11), test.getHealthPoints());
        assertEquals("Ambitious", test.getDescription());
        assertEquals("Slytherin", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
