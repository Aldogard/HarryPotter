package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void testAnimal() {
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Animal animal = new Animal("testAnimal", 1.0, 1.0,
                1, 1.0, 0.1, false, false, false, false, test, "Strong" );

        assertNotNull(animal);
        assertEquals("testAnimal", animal.getName());
        assertEquals(BigDecimal.valueOf(1.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), animal.getMaxDamage());
        assertEquals("Strong", animal.getDescriptionOption());
        assertEquals(1, animal.getRequiredExperience());
        assertEquals(BigDecimal.valueOf(1.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.1), animal.getEnergyRecovery());
        assertEquals(test, animal.getMagicalBeing());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }
}
