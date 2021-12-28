package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OptionsTest {

    @Test
    public void testOptions(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Spell spell = new Spell("testO", 1.0, 1.0, 0.5, false, false, false, false, false, false, false, 1, test, "Strong");
        assertNotNull(spell);
        assertEquals("testO", spell.getName());
        assertEquals(BigDecimal.valueOf(1.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), spell.getMaxDamage());
        assertEquals("Strong", spell.getDescriptionOption());
        assertEquals(1, spell.getRequiredExperience());

    }
}
