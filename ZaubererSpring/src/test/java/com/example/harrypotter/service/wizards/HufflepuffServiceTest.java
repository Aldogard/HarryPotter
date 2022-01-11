package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Hufflepuff;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.wizards.ConditionRepo;
import com.example.harrypotter.repo.wizards.StrengthAndWeaknessRepo;
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
public class HufflepuffServiceTest {
    @Autowired
    private HufflepuffService hufflepuffService;

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
    public void testHufflepuffService() {
        Hufflepuff hufflepuff = new Hufflepuff("Test", BigDecimal.valueOf(10), "test and more than 10");
        ResponseEntity<Wizard> response = hufflepuffService.createHufflepuff(hufflepuff);

        Wizard wizardResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        HttpStatus httpStatus = hufflepuffService.createHufflepuff(hufflepuff).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, wizardRepo.findAll().size());
        assertNotNull(wizardRepo.findByName("Test").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizards.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(6, spells.size());
        assertTrue(UtilWizards.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(4, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(1, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(2, UtilWizards.findStrength(saWRepo.findAll()).size());
        assertEquals(7, UtilWizards.findWeaknesses(saWRepo.findAll()).size());
    }
}
