package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Hufflepuff;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HufflepuffTest {
    @Test
    public void testHufflepuffConstructor(){
        Hufflepuff test = new Hufflepuff("TestH", BigDecimal.valueOf(7), "Loyal");
        assertNotNull(test);
        assertEquals("TestH", test.getName());
        assertEquals(BigDecimal.valueOf(7), test.getHealthPoints());
        assertEquals("Loyal", test.getDescription());
        assertEquals("Hufflepuff", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.1), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}
