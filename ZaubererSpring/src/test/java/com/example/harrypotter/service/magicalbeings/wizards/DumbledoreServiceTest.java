package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.StrengthAndWeaknessRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
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
public class DumbledoreServiceTest {

    @Autowired
    private DumbledoreService dumbledoreService;

    @Autowired
    private WizardRepo wizardRepo;

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

    @AfterEach
    public void deleteAll() {
        wizardRepo.deleteAll();
    }

    @Test
    public void testDumbledoreService() {
        Dumbledore dumbledore = new Dumbledore("Test", BigDecimal.valueOf(10), "test and more than 10");
        ResponseEntity<Wizard> response = dumbledoreService.createDumbledore(dumbledore);

        Wizard wizardResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);


        Dumbledore dumbledore1 = new Dumbledore("Different Name", BigDecimal.valueOf(20), "test");
        HttpStatus httpStatus1 = dumbledoreService.createDumbledore(dumbledore1).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus1);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, wizardRepo.findAll().size());
        assertNotNull(wizardRepo.findByName("Test").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizards.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(12, spells.size());
        assertTrue(UtilWizards.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(7, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(1, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(7, UtilWizards.findStrength(saWRepo.findAll()).size());
        assertEquals(2, UtilWizards.findWeaknesses(saWRepo.findAll()).size());
    }



}