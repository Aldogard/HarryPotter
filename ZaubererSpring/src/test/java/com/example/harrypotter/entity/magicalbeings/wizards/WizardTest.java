package com.example.harrypotter.entity.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import com.example.harrypotter.entity.magicalbeings.wizards.StrengthAndWeakness;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WizardTest {
    @Test
    public void testWizard(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");

        assertNotNull(test);
        assertEquals("TestW", test.getName());
        assertEquals(BigDecimal.valueOf(4), test.getHealthPoints());
        assertEquals("Neutral", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals("Wizard", test.getSpecies());

    }



}
