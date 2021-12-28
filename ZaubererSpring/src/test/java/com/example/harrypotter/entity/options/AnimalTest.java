package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.wizards.Dumbledore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {

    @Test
    public void testAnimal() {
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Animal animal = new Animal("testAnimal", 1.0, 1.0, 1, 1.0, 0.1, test, "Strong" );

        assertNotNull(animal);
        assertEquals("testAnimal", animal.getName());
        assertEquals(BigDecimal.valueOf(1.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), animal.getMaxDamage());
        assertEquals("Strong", animal.getDescriptionOption());
        assertEquals(1, animal.getRequiredExperience());
        assertEquals(BigDecimal.valueOf(1.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.1), animal.getEnergyRecovery());
        assertEquals(test, animal.getWizard());

    }
}
