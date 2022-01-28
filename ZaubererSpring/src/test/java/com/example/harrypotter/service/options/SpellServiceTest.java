package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpellServiceTest {
    @Autowired
    private SpellService spellService;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private SpellRepo spellRepo;

    @AfterEach
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
        spellRepo.deleteAll();
    }

    private Spell checkSavingOfSpell(){
        assertNotNull(spellRepo.findAll());
        assertEquals(1, spellRepo.findAll().size());
        return spellRepo.findAll().get(0);
    }

    @Test
    public void testCreateExpelliarmus() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createExpelliarmus(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Expelliarmus", spell.getName());
        assertEquals(BigDecimal.valueOf(5.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(10.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalse(spell));
        assertEquals(0, spell.getRequiredExperience());
    }

    @Test
    public void testCreateStupefy() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createStupefy(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Stupefy", spell.getName());
        assertEquals(BigDecimal.valueOf(7.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(2.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalseExceptStunned(spell));
        assertEquals(5, spell.getRequiredExperience());
    }

    @Test
    public void testCreateLevicorpus() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createLevicorpus(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Levicorpus", spell.getName());
        assertEquals(BigDecimal.valueOf(3.5), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(5.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalseExceptConfunded(spell));
        assertEquals(0, spell.getRequiredExperience());
    }

    @Test
    public void testCreateCalvorio() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createCalvorio(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Calvorio", spell.getName());
        assertEquals(BigDecimal.valueOf(1.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(3.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalse(spell));
        assertEquals(0, spell.getRequiredExperience());
    }

    @Test
    public void testCreateImmobilus() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createImmobilus(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Immobilus", spell.getName());
        assertEquals(BigDecimal.valueOf(3.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalseExceptStunned(spell));
        assertEquals(0, spell.getRequiredExperience());
    }

    @Test
    public void testCreateSectumssempra() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createSectumssempra(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Sectumssempra", spell.getName());
        assertEquals(BigDecimal.valueOf(10.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(17.5), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalse(spell));
        assertEquals(10, spell.getRequiredExperience());
    }

    @Test
    public void testCreateConfundo() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createConfundo(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Confundo", spell.getName());
        assertEquals(BigDecimal.valueOf(2.5), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalseExceptConfunded(spell));
        assertEquals(3, spell.getRequiredExperience());
    }

    @Test
    public void testCreateAvadaKedavra() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createAvadaKedavra(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Avada Kedavra", spell.getName());
        assertEquals(BigDecimal.valueOf(25.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(40.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue(UtilOptions.allFalse(spell));
        assertEquals(25, spell.getRequiredExperience());
    }

    @Test
    public void testCreateImperio() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createImperio(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Imperio", spell.getName());
        assertEquals(BigDecimal.valueOf(15.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(5.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( !spell.getStunned() &&
                spell.getConfunded() &&
                spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre());
        assertEquals(15, spell.getRequiredExperience());
    }

    @Test
    public void testCreateCrucio() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createCrucio(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Crucio", spell.getName());
        assertEquals(BigDecimal.valueOf(15.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(25.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( !spell.getStunned() &&
                spell.getConfunded() &&
                !spell.getImperio() &&
                spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre());
        assertEquals(20, spell.getRequiredExperience());
    }
    @Test
    public void testCreateProtego() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createProtego(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Protego", spell.getName());
        assertEquals(BigDecimal.valueOf(10.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( !spell.getStunned() &&
                !spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre());
        assertEquals(5, spell.getRequiredExperience());
    }

    @Test
    public void testCreateFiendfyre() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createFiendfyre(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Fiendfyre", spell.getName());
        assertEquals(BigDecimal.valueOf(20.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(50.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( !spell.getStunned() &&
                !spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                spell.getFiendfyre() &&
                !spell.getAntiFiendfyre());
        assertEquals(20, spell.getRequiredExperience());
    }

    @Test
    public void testCreateAntiFiendfyre() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createAntiFiendfyre(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Anti Fiendfyre", spell.getName());
        assertEquals(BigDecimal.valueOf(10.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( !spell.getStunned() &&
                !spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                spell.getAntiFiendfyre());
        assertEquals(25, spell.getRequiredExperience());
    }

    @Test
    public void testCreateFirestorm() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createFirestorm(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Firestorm", spell.getName());
        assertEquals(BigDecimal.valueOf(15.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(27.5), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( UtilOptions.allFalse(spell));
        assertEquals(15, spell.getRequiredExperience());
    }

    @Test
    public void testCreatePiertotumLocomotor() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createPiertotumLocomotor(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Piertotum Locomotor", spell.getName());
        assertEquals(BigDecimal.valueOf(10.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(20.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( UtilOptions.allFalse(spell));
        assertEquals(15, spell.getRequiredExperience());
    }

    @Test
    public void testCreateVulneraSanentur() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createVulneraSanentur(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Vulnera Sanentur", spell.getName());
        assertEquals(BigDecimal.valueOf(15.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.8), spell.getHealing());
        assertTrue( UtilOptions.allFalse(spell));
        assertEquals(15, spell.getRequiredExperience());
    }

    @Test
    public void testCreatePertrificusTotalus() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createPertrificusTotalus(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Pertrificus Totalus", spell.getName());
        assertEquals(BigDecimal.valueOf(5.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getHealing());
        assertTrue( UtilOptions.allFalseExceptStunned(spell));
        assertEquals(1, spell.getRequiredExperience());
    }

    @Test
    public void testCreateEpiskey() {
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        spellService.createEpiskey(alumni);

        Spell spell = checkSavingOfSpell();

        assertEquals("Episkey", spell.getName());
        assertEquals(BigDecimal.valueOf(5.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(0.0), spell.getMaxDamage());
        assertEquals(BigDecimal.valueOf(0.1), spell.getHealing());
        assertTrue( UtilOptions.allFalse(spell));
        assertEquals(1, spell.getRequiredExperience());
    }
}