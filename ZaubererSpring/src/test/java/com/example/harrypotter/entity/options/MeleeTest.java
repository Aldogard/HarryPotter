package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class MeleeTest {

    @Test
    public void testMeleeConstructor(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Melee melee = new Melee("testMelee", 1.0, 1.0,
                1, false, false, test, "Strong" );

        assertNotNull(melee);
        assertEquals("testMelee", melee.getName());
        assertEquals(BigDecimal.valueOf(1.0), melee.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), melee.getMaxDamage());
        assertEquals("Strong", melee.getDescriptionOption());
        assertEquals(1, melee.getRequiredExperience());
        assertEquals(BigDecimal.valueOf(0.0), melee.getHealing());
        assertFalse(melee.getStunned());
        assertFalse(melee.getConfunded());
        assertEquals(test, melee.getMagicalBeing());
    }
}
