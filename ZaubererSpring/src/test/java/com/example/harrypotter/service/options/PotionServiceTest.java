package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PotionServiceTest {
    private final int storage = 5;
    @Autowired
    private PotionService potionService;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private PotionsRepo potionsRepo;

    @AfterEach
    public void deleteAll() {
        magicalBeingRepo.deleteAll();
        potionsRepo.deleteAll();
    }

    private Potion checkSavingOfPotion() {
        assertNotNull(potionsRepo.findAll());
        assertEquals(1, potionsRepo.findAll().size());
        assertEquals(storage, potionsRepo.findAll().get(0).getStorage());
        return potionsRepo.findAll().get(0);
    }

    @Test
    public void testCreateAntiParalysis() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createAntiParalysis(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Anti-Paralysis", potion.getName());
        assertEquals(BigDecimal.valueOf(0.0), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), potion.getEnergyRecovery());
        assertTrue(potion.getAntiParalysis() &&
                !potion.getAntiConfunded() &&
                !potion.getRegeneration() &&
                !potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(0, potion.getRequiredExperience());
    }

    @Test
    public void testCreateBrainElixier() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createBrainElixir(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Baruffios Brain Elixir", potion.getName());
        assertTrue(UtilOptions.allFalseZeroRecoveryAndHealing(potion));
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.5), potion.getAdditionalFactor());
        assertEquals(5, potion.getRequiredExperience());
    }

    @Test
    public void testCreateExplodingPotion() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createExplodingPotion(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Exploding Potion", potion.getName());
        assertTrue(UtilOptions.allFalseZeroRecoveryAndHealing(potion));
        assertEquals(BigDecimal.valueOf(10.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(5, potion.getRequiredExperience());
    }

    @Test
    public void testCreateHealingPotion() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createHealingPotion(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Healing Potion", potion.getName());
        assertEquals(BigDecimal.valueOf(0.35), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.1), potion.getEnergyRecovery());
        assertTrue(UtilOptions.allFalse(potion));
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(0, potion.getRequiredExperience());
    }

    @Test
    public void testCreateInvogiration() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createInvogiration(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Invigoration Draught", potion.getName());
        assertEquals(BigDecimal.valueOf(0.0), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.8), potion.getEnergyRecovery());
        assertTrue(UtilOptions.allFalse(potion));
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(0, potion.getRequiredExperience());
    }

    @Test
    public void testCreateUnicornBlood() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createUnicornBlood(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Unicorn Blood", potion.getName());
        assertEquals(BigDecimal.valueOf(-0.5), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), potion.getEnergyRecovery());
        assertTrue(!potion.getAntiParalysis() &&
                !potion.getAntiConfunded() &&
                !potion.getRegeneration() &&
                potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(10, potion.getRequiredExperience());
    }

    @Test
    public void testCreateRegenrationPotion() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createRegenerationPotion(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Regeneration Potion", potion.getName());
        assertEquals(BigDecimal.valueOf(-0.5), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), potion.getEnergyRecovery());
        assertTrue(!potion.getAntiParalysis() &&
                !potion.getAntiConfunded() &&
                potion.getRegeneration() &&
                !potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(15, potion.getRequiredExperience());
    }

    @Test
    public void testCreateWitSharpeningPotion() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createWitSharpeningPotion(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Wit-Sharpening Potion", potion.getName());
        assertEquals(BigDecimal.valueOf(0.0), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.0), potion.getEnergyRecovery());
        assertTrue(!potion.getAntiParalysis() &&
                potion.getAntiConfunded() &&
                !potion.getRegeneration() &&
                !potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.0), potion.getAdditionalFactor());
        assertEquals(3, potion.getRequiredExperience());
    }

    @Test
    public void testCreateExtimuloPotion() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createExtimuloPotion(alumni, storage);

        Potion potion = checkSavingOfPotion();

        assertEquals("Extimulo Potion", potion.getName());
        assertTrue(UtilOptions.allFalseZeroRecoveryAndHealing(potion));
        assertEquals(BigDecimal.valueOf(0.0), potion.getMaxDamage());
        assertEquals(BigDecimal.valueOf(1.25), potion.getAdditionalFactor());
        assertEquals(0, potion.getRequiredExperience());
    }









}
