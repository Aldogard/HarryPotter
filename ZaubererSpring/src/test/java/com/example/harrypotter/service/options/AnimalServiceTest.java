package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.AnimalRepo;
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
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private AnimalRepo animalRepo;

    @AfterEach
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
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
        magicalBeingRepo.save(alumni);
        animalService.createPhoenix(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Fawkes", animal.getName());
        assertEquals(BigDecimal.valueOf(10.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(25, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateFlobberworm(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createFlobberworm(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Flobberworm", animal.getName());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.1), animal.getEnergyRecovery());
        assertEquals(0, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateBasilisk(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createBasilisk(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Basilisk", animal.getName());
        assertEquals(BigDecimal.valueOf(25.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(50.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(30, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreatePoisonousDuck(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createPoisonousDuck(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Poisonous duck", animal.getName());
        assertEquals(BigDecimal.valueOf(2.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(5.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(0, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateBowtuckle(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createBowtuckle(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Bowtuckle", animal.getName());
        assertEquals(BigDecimal.valueOf(1.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(3.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(0, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateHungarianHonrtail(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createHungarianHorntail(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Hungarian Horntail", animal.getName());
        assertEquals(BigDecimal.valueOf(25.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(40.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(25, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateFireCrabs(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createFireCrabs(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Fire crab", animal.getName());
        assertEquals(BigDecimal.valueOf(5.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(10.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(15, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateGriffin(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createGriffin(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Griffin", animal.getName());
        assertEquals(BigDecimal.valueOf(10.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(15.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(10, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateHippogriff(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createHippogriff(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Hippogriff", animal.getName());
        assertEquals(BigDecimal.valueOf(12.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(20.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(15, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateNiffler(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createNiffler(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Niffler", animal.getName());
        assertEquals(BigDecimal.valueOf(5.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(10, animal.getRequiredExperience());
        assertTrue(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateThreeHeadedDog(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createThreeHeadedDog(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Fluffy", animal.getName());
        assertEquals(BigDecimal.valueOf(15.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(25.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(20, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateTroll(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createTroll(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Troll", animal.getName());
        assertEquals(BigDecimal.valueOf(3.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(7.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(3, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertFalse(animal.getWater());
        assertFalse(animal.getForest());
    }

    @Test
    public void testCreateAcromantula(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createAcromantula(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Aragog", animal.getName());
        assertEquals(BigDecimal.valueOf(15.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(20.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(15, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getForest());
        assertFalse(animal.getWater());
    }

    @Test
    public void testCreateGrindelow(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createGrindelow(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Grindelow", animal.getName());
        assertEquals(BigDecimal.valueOf(2.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(6.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(7, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }

    @Test
    public void testCreateKappa(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createKappa(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Kappa", animal.getName());
        assertEquals(BigDecimal.valueOf(5.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(10.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(7, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }

    @Test
    public void testCreateKelpie(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createKelpie(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Kelpie", animal.getName());
        assertEquals(BigDecimal.valueOf(3.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(7.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(5, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }

    @Test
    public void testCreateMerpeople(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createMerpeople(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Merpeople", animal.getName());
        assertEquals(BigDecimal.valueOf(10.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(17.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(25, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }

    @Test
    public void testCreateSelma(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        animalService.createSelma(alumni);

        Animal animal = checkSavingOfAnimal();

        assertEquals("Selma", animal.getName());
        assertEquals(BigDecimal.valueOf(15.0), animal.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(25.0), animal.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), animal.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), animal.getEnergyRecovery());
        assertEquals(20, animal.getRequiredExperience());
        assertFalse(animal.getNiffler());
        assertTrue(animal.getWater());
        assertFalse(animal.getForest());
        assertFalse(animal.getCastle());

    }
}
