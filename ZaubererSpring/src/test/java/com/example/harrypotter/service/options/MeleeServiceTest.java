package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
import com.example.harrypotter.entity.options.Melee;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.MeleeRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class MeleeServiceTest {
    @Autowired
    private MeleeRepo meleeRepo;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private MeleeService meleeService;

    @AfterEach
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
        meleeRepo.deleteAll();
    }

    private Melee checkSavingOfGiant(){
        assertNotNull(meleeRepo.findAll());
        assertEquals(1, meleeRepo.findAll().size());
        return meleeRepo.findAll().get(0);
    }

    @Test
    public void testCreateGurgAttack(){
        Gurg gurg = new Gurg("Gurg", BigDecimal.valueOf(10), "Test and more than 10");
        magicalBeingRepo.save(gurg);
        meleeService.createGurgAttack(gurg);

        Melee melee = checkSavingOfGiant();

        assertEquals("Gurg Attack", melee.getName());
        assertEquals(BigDecimal.valueOf(25.0), melee.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(40.0), melee.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), melee.getHealing());
        assertEquals(5, melee.getRequiredExperience());
        assertFalse(melee.getConfunded());
        assertTrue(melee.getStunned());
    }

    @Test
    public void testCreatePunch(){
        Gurg gurg = new Gurg("Gurg", BigDecimal.valueOf(10), "Test and more than 10");
        magicalBeingRepo.save(gurg);
        meleeService.createPunch(gurg);

        Melee melee = checkSavingOfGiant();

        assertEquals("Punch", melee.getName());
        assertEquals(BigDecimal.valueOf(10.0), melee.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(15.0), melee.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), melee.getHealing());
        assertEquals(0, melee.getRequiredExperience());
        assertFalse(melee.getStunned());
        assertTrue(melee.getConfunded());
    }
}
