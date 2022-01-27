package com.example.harrypotter.service.magicalbeings.wizards;


import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;

import com.example.harrypotter.entity.magicalbeings.Condition;
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


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumniServiceTest {

    @Autowired
    private AlumniService alumniService;

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
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
    }

    @Test
    public void testAlumniService() {
        Alumni alumni = UtilWizards.createTesti();
        ResponseEntity<Wizard> response = alumniService.createAlumni(alumni);

        Wizard wizardResponse =response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        HttpStatus httpStatus = alumniService.createAlumni(alumni).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, magicalBeingRepo.findAll().size());
        assertNotNull(magicalBeingRepo.findByName("Testi").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizards.numberOfConditions, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(7, spells.size());
        assertTrue(UtilWizards.checkFiendfyre(spells));

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(6, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(7, animals.size());

        assertNotNull(saWRepo.findAll());
        assertEquals(4, UtilWizards.findStrength(saWRepo.findAll()).size());
        assertEquals(6, UtilWizards.findWeaknesses(saWRepo.findAll()).size());

        List<Hint> hints = hintRepo.findAll();
        assertNotNull(hints);
        assertEquals(15, hints.size());

    }
}