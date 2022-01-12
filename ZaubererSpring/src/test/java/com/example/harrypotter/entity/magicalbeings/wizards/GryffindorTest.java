package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Gryffindor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GryffindorTest {
    @Test
    public void testGryffindorConstructor(){
        Gryffindor test = new Gryffindor("TestG", BigDecimal.valueOf(5), "Brave");
        assertNotNull(test);
        assertEquals("TestG", test.getName());
        assertEquals(BigDecimal.valueOf(5), test.getHealthPoints());
        assertEquals("Brave", test.getDescription());
        assertEquals("Gryffindor", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
