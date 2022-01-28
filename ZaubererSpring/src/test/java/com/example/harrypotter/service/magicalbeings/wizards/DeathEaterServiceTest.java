package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.DeathEater;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.HintRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.StrengthAndWeaknessRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DeathEaterServiceTest {
    @Autowired
    private DeathEaterService deathEaterService;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private SpellRepo spellRepo;

    @Autowired
    private PotionsRepo potionsRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private AnimalRepo animalRepo;

    @Autowired
    private StrengthAndWeaknessRepo saWRepo;

    @Autowired
    private HintRepo hintRepo;

    @AfterEach
    public void deleteAll() {
        magicalBeingRepo.deleteAll();
    }

    @Test
    public void testDeathEaterService() {
        DeathEater deathEater = new DeathEater("Test", BigDecimal.valueOf(10), "test  and more than 10");
        ResponseEntity<Wizard> response = deathEaterService.createDeathEater(deathEater);

        Wizard wizardResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        HttpStatus httpStatus = deathEaterService.createDeathEater(deathEater).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, magicalBeingRepo.findAll().size());
        assertNotNull(magicalBeingRepo.findByName("Test").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizard.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(9, spells.size());
        assertTrue(UtilWizard.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(5, potions.size());
        assertTrue(findRegenerationPotion(potions));

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(5, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(4, UtilWizard.findStrength(saWRepo.findAll()).size());
        assertEquals(6, UtilWizard.findWeaknesses(saWRepo.findAll()).size());

        List<Hint> hints = hintRepo.findAll();
        assertNotNull(hints);
        assertEquals(13, hints.size());
    }


    public boolean findRegenerationPotion(List<Potion> potionList) {
        for (Potion potion : potionList) {
            if (potion.getRegeneration())
                return true;
        }
        return false;
    }
}

