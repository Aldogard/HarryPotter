package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PotionTest {

    @Test
    public void testPotion(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Potion potion = new Potion("testPotion", 2, 0.5 , 0.3, false, false, false, false, 2.0, 1.5, 3, test, "Rare");

        assertNotNull(potion);
        assertEquals("testPotion", potion.getName());
        assertEquals(BigDecimal.valueOf(2.0), potion.getMaxDamage());
        assertEquals("Rare", potion.getDescriptionOption());
        assertEquals(3, potion.getRequiredExperience());

        assertEquals(2, potion.getStorage());
        assertEquals(BigDecimal.valueOf(0.5), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.3), potion.getEnergyRestorage());
        assertFalse(potion.getAntiParalysis());
        assertFalse(potion.getAntiConfunded());
        assertFalse(potion.getRegeneration());
        assertFalse(potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(1.5), potion.getAdditionalFactor());
        assertEquals(test, potion.getWizard());

    }

}
