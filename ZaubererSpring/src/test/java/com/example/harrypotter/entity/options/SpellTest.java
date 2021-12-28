package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SpellTest {

    @Test
    public void testSpell(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Spell spell = new Spell("testSpell", 2.0, 2.0, 0.5, false, false, false, false, false, false, false, 2, test, "Powerful");
        assertNotNull(spell);
        assertEquals("testSpell", spell.getName());
        assertEquals(BigDecimal.valueOf(2.0), spell.getMaxDamage());
        assertEquals("Powerful", spell.getDescriptionOption());
        assertEquals(2, spell.getRequiredExperience());
        assertEquals(0.5, spell.getHealing());

        assertEquals(BigDecimal.valueOf(2.0), spell.getEnergyUsage());
        assertFalse(spell.getStunned());
        assertFalse(spell.getConfunded());
        assertFalse(spell.getImperio());
        assertFalse(spell.getCrucio());
        assertFalse(spell.getProtego());
        assertFalse(spell.getFiendfyre());
        assertFalse(spell.getAntiFiendfyre());
        assertEquals(test, spell.getWizard());

    }
}
