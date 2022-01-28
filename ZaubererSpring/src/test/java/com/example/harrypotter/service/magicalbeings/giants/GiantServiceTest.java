package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
import com.example.harrypotter.entity.magicalbeings.giants.Hagrid;
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

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testCheckHouse(){
        Hagrid hagrid = UtilGiant.createHagrid();
        Gurg gurg = UtilGiant.createGurg();
        magicalBeingRepo.save(hagrid);

        assertTrue(giantService.checkHouse(hagrid));
        assertFalse(giantService.checkHouse(gurg));

    }
}
