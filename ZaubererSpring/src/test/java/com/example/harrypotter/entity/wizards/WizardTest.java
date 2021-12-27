package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class WizardTest {
    @Test
    public void testWizard(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Condition condition = new Condition(test, "Bad");
        Spell spell = new Spell("testSpell", 1.0, 1.0, false, false, false, false, false, false, false, 1, test, "Amazing");
        Potion potion = new Potion("testPotion", 1, 1.0 , 0.35, false, false, false, false, 1.0, 1.0, 1, test, "Average");
        Comments comments = new Comments("test", test);
        StrengthAndWeakness saw = new StrengthAndWeakness("ALumni", false, test);

        assertNotNull(test);
        assertEquals("TestW", test.getName());
        assertEquals(BigDecimal.valueOf(4), test.getHealthPoints());
        assertEquals("Neutral", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals(BigDecimal.valueOf(2.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(BigDecimal.valueOf(25.0), test.getEnergy());
        assertEquals(test.getEnergy(), test.getInternEnergy());
        assertEquals(BigDecimal.valueOf(1.0), test.getAdditionalFactor());
        assertFalse(test.getHalfLife());
        assertEquals(0, test.getStunnedProtection());
        assertEquals(0, test.getConfundedProtection());
        assertFalse(test.getProtego());
        assertFalse(test.getFiendfyre());
        assertEquals(0, test.getPtCounter());
        assertEquals(0, test.getVictories());
        assertEquals(0, test.getAmount());
        assertEquals("Dursley", test.getRank());
        assertEquals(BigDecimal.valueOf(0.0), test.getRating());
//        //Test bei Service
//        assertNotNull(test.getConditions());
//        assertNotNull(test.getSpells());
//        assertNotNull(test.getPotions());
//        assertNotNull(test.getComments());
//        assertNotNull(test.getStrengthAndWeaknesses());
    }



}
