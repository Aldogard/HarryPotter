package com.example.harrypotter.entity.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class HintTest {


    @Test
    public void testHintsConstructor(){
        Alumni test = new Alumni("Testi", BigDecimal.valueOf(10), "Test and more than 10");

        Hint hint = new Hint("I would move another piece", false, false, false, test);
        assertNotNull(hint);
        assertEquals("I would move another piece", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }
}
