package com.example.harrypotter.service.magicalbeings.giants;


import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.StrengthAndWeaknessRepo;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class GiantServiceTest {

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private GiantService giantService;

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
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
    }


    @Test
    public void testCreateGiant(){
        Giant giant = new Giant("Testi1", BigDecimal.valueOf(10), "Test and more than 10");
        ResponseEntity<Giant> response = giantService.createGiant(giant);

        MagicalBeing mbResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        HttpStatus httpStatus = giantService.createGiant(giant).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus);

        assertNotNull(mbResponse);
        assertNotNull(mbResponse.getName());
        assertEquals(1, magicalBeingRepo.findAll().size());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(2, conditions.size());

        List<Spell> spells = spellRepo.findAll();
        assertNotNull(spells);
        assertEquals(1, spells.size());

        List<Potion> potions = potionsRepo.findAll();
        assertNotNull(potions);
        assertEquals(0, potions.size());

        List<Animal> animals = animalRepo.findAll();
        assertNotNull(animals);
        assertEquals(0, animals.size());

        assertNotNull(saWRepo.findAll());

    }
}
