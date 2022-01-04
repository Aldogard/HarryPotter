package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.wizards.Condition;
import com.example.harrypotter.entity.wizards.DeathEater;
import com.example.harrypotter.entity.wizards.Dumbledore;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.wizards.ConditionRepo;
import com.example.harrypotter.repo.wizards.SaWRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
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
    private SaWRepo saWRepo;

    @AfterEach
    public void deleteAll() {
        wizardRepo.deleteAll();
    }

    @Test
    public void testDumbledoreService() {
        Dumbledore dumbledore = new Dumbledore("Test", BigDecimal.valueOf(10), "test");
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
        assertEquals(Util.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(12, spells.size());
        assertTrue(Util.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(7, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(1, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(7, Util.findStrength(saWRepo.findAll()).size());
        assertEquals(2, Util.findWeaknesses(saWRepo.findAll()).size());
    }



}
