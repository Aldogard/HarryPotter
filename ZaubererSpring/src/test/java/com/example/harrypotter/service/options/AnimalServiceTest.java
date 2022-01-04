package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.wizards.Alumni;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AnimalServiceTest {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private WizardRepo wizardRepo;

    @Autowired
    private AnimalRepo animalRepo;

    @AfterEach
    public void deleteAll(){
        wizardRepo.deleteAll();
        animalRepo.deleteAll();
    }

    private Animal checkSavingOfAnimal(){
        assertNotNull(animalRepo.findAll());
        assertEquals(1, animalRepo.findAll().size());
        return animalRepo.findAll().get(0);
    }

    @Test
    public void testCreatePhoenix(){
        Alumni alumni = UtilOptions.createTesti();
        wizardRepo.save(alumni);
        animalService.createPhoenix(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Fawkes", animal.getName());
        assertEquals(BigDecimal.valueOf(10.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(25, animal.getRequiredExperience());
    }

    @Test
    public void testCreateFlobberworm(){
        Alumni alumni = UtilOptions.createTesti();
        wizardRepo.save(alumni);
        animalService.createFlobberworm(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Flobberworm", animal.getName());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.1), animal.getEnergyRecovery());
        assertEquals(0, animal.getRequiredExperience());
    }

}
