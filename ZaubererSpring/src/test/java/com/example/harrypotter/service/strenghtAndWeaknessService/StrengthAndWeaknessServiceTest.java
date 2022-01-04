package com.example.harrypotter.service.strenghtAndWeaknessService;

import com.example.harrypotter.entity.wizards.Alumni;
import com.example.harrypotter.repo.wizards.StrengthAndWeaknessRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.options.UtilOptions;
import com.example.harrypotter.service.strengthAndWeaknessService.StrengthAndWeaknessService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StrengthAndWeaknessServiceTest {
    @Autowired
    private StrengthAndWeaknessService sawService;

    @Autowired
    private WizardRepo wizardRepo;

    @Autowired
    private StrengthAndWeaknessRepo sawRepo;

    @AfterEach
    public void deleteAll(){
        wizardRepo.deleteAll();
        sawRepo.deleteAll();
    }

    private Alumni createAndSaveAlumni(){
        Alumni alumni = UtilOptions.createTesti();
        wizardRepo.save(alumni);
        return alumni;
    }

    private void checkSavingOfSaW(String house){
        assertNotNull(sawRepo.findAll());
        assertEquals(2, sawRepo.findAll().size());

        assertEquals(house, sawRepo.findAll().get(0).getHouse());
        assertTrue(sawRepo.findAll().get(0).getStrength());

        assertEquals(house, sawRepo.findAll().get(1).getHouse());
        assertFalse(sawRepo.findAll().get(1).getStrength());
    }

    @Test
    public void testSaWHeadmaster(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthHeadmaster(alumni);
        sawService.weaknessHeadmaster(alumni);
        checkSavingOfSaW("Headmaster");
    }

    @Test
    public void testSaWVoldemort(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthVoldemort(alumni);
        sawService.weaknessVoldmort(alumni);
        checkSavingOfSaW("Voldemort");
    }

    @Test
    public void testSaWHufflepuff(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthHufflepuff(alumni);
        sawService.weaknessHufflepuff(alumni);
        checkSavingOfSaW("Hufflepuff");
    }

    @Test
    public void testSaWDeathEater(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthDeathEater(alumni);
        sawService.weaknessDeathEater(alumni);
        checkSavingOfSaW("DeathEater");
    }

    @Test
    public void testSaWHGryffindor(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthGryffindor(alumni);
        sawService.weaknessGryffindor(alumni);
        checkSavingOfSaW("Gryffindor");
    }

    @Test
    public void testSaWSlytherin(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthSlytherin(alumni);
        sawService.weaknessSlytherin(alumni);
        checkSavingOfSaW("Slytherin");
    }

    @Test
    public void testSaWRavenclaw(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthRavenclaw(alumni);
        sawService.weaknessRavenclaw(alumni);
        checkSavingOfSaW("Ravenclaw");
    }

    @Test
    public void testSaWAlumni(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthAlumni(alumni);
        sawService.weaknessAlumni(alumni);
        checkSavingOfSaW("Alumni");
    }

    @Test
    public void testSaWProfessor(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthProfessor(alumni);
        sawService.weaknessProfessor(alumni);
        checkSavingOfSaW("Professor");
    }

    @Test
    public void testSaWDumbledore(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthDumbledore(alumni);
        sawService.weaknessDumbledore(alumni);
        checkSavingOfSaW("Dumbledore");
    }

    @Test
    public void testSaWPotionsMaster(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthPotionsMaster(alumni);
        sawService.weaknessPotionsMaster(alumni);
        checkSavingOfSaW("Potions Master");
    }

    @Test
    public void testSaWHogwartsHouses(){
        Alumni alumni = createAndSaveAlumni();
        sawService.strengthHogwartsHouse(alumni);
        for (int i=0; i<4; i++) {
            assertTrue(sawRepo.findAll().get(i).getStrength());
        }
        assertEquals("Gryffindor", sawRepo.findAll().get(0).getHouse());
        assertEquals("Slytherin", sawRepo.findAll().get(1).getHouse());
        assertEquals("Hufflepuff", sawRepo.findAll().get(2).getHouse());
        assertEquals("Ravenclaw", sawRepo.findAll().get(3).getHouse());

    }









}
