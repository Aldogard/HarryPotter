package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Slytherin;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SlytherinServiceTest {
    @Autowired
    private SlytherinService slytherinService;

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
    public void testHufflepuffService() {
        Slytherin slytherin = new Slytherin("Test", BigDecimal.valueOf(10), "test and more than 10");
        ResponseEntity<Wizard> response = slytherinService.createSlytherin(slytherin);

        Wizard wizardResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        HttpStatus httpStatus = slytherinService.createSlytherin(slytherin).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, magicalBeingRepo.findAll().size());
        assertNotNull(magicalBeingRepo.findByName("Test").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizards.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(6, spells.size());
        assertTrue(UtilWizards.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(6, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(5, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(3, UtilWizards.findStrength(saWRepo.findAll()).size());
        assertEquals(6, UtilWizards.findWeaknesses(saWRepo.findAll()).size());

        List<Hint> hints = hintRepo.findAll();
        assertNotNull(hints);
        assertEquals(15, hints.size());
    }
}
