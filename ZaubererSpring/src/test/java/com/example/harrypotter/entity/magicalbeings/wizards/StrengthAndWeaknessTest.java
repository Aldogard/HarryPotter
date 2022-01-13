package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.StrengthAndWeakness;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrengthAndWeaknessTest {
    @Test
    public void testStrengthAndWeakness(){
        Alumni test = new Alumni("Test", BigDecimal.valueOf(25), "Test");
        StrengthAndWeakness saw = new StrengthAndWeakness("Hufflepuff", true, test);
        assertNotNull(saw);
        assertEquals("Hufflepuff", saw.getHouse());
        assertTrue(saw.getStrength());
        assertEquals(test, saw.getMagicalBeing());
    }
}
