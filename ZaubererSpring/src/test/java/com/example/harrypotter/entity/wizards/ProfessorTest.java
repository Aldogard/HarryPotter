package com.example.harrypotter.entity.wizards;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProfessorTest {
    @Test
    public void testProfessorConstructor(){
        Professor test = new Professor("TestP", BigDecimal.valueOf(9), "Boss");
        assertNotNull(test);
        assertEquals("TestP", test.getName());
        assertEquals(BigDecimal.valueOf(9), test.getHealthPoints());
        assertEquals("Boss", test.getDescription());
        assertEquals("Professor", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
