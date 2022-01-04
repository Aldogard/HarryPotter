package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.wizards.ConditionRepo;
import com.example.harrypotter.repo.wizards.SaWRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.wizards.DeathEaterService;
import com.example.harrypotter.service.wizards.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeathEaterTest {

    @Test
    public void testAlumniConstructor() {
        DeathEater test = new DeathEater("TestC", BigDecimal.valueOf(2), "dangerous");
        assertNotNull(test);
        assertEquals("TestC", test.getName());
        assertEquals(BigDecimal.valueOf(2), test.getHealthPoints());
        assertEquals("dangerous", test.getDescription());
        assertEquals("DeathEater", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }
}

