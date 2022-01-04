package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.wizards.*;
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

@DataJpaTest
public class WizardServiceTest {

    @Autowired
    private WizardService wizardService;

    @Autowired
    private WizardRepo wizardRepo;

    @AfterEach
    public void deleteAll(){
        wizardRepo.deleteAll();
    }

    @Test
    public void testQuote() {
        assertNotNull(wizardService.quote());
    }

    @Test
    public void testWizardRepo() {
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);
        assertNotNull(alumni);
        assertEquals(1, wizardRepo.findAll().size());
    }

    @Test
    public void testGetWizardById() {
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);
        ResponseEntity<Wizard> response= wizardService.getWizardById(alumni.getId());
        assertNotNull(response);
        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testUpdateWizard(){
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);

        ResponseEntity<Wizard> responseTest = wizardService.updateWizard(
                new Headmaster(
                        "Testi",
                        BigDecimal.valueOf(5),
                        "NEW"), 10000);
        assertNull(responseTest.getBody());
        assertEquals(HttpStatus.FORBIDDEN, responseTest.getStatusCode());

        ResponseEntity<Wizard> response = wizardService.updateWizard(
                new Headmaster(
                        "Testi",
                        BigDecimal.valueOf(5),
                        "NEW"), alumni.getId());
        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testDeleteWizard(){
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);
        assertEquals(1, wizardRepo.findAll().size());
        ResponseEntity<Void> responseTestLessThanFive = wizardService.deleteWizard(alumni.getId());
        assertNull(responseTestLessThanFive.getBody());
        assertEquals(HttpStatus.FORBIDDEN, responseTestLessThanFive.getStatusCode());

        for (int i=0; i<5; i++){
            String number = "Testi " + i;
            wizardRepo.save(new Alumni(number, BigDecimal.valueOf(10), "Test"));
        }

        assertEquals(6, wizardRepo.findAll().size());

        ResponseEntity<Void> responseTestWrongId = wizardService.deleteWizard(1000);
        assertNull(responseTestWrongId.getBody());
        assertEquals(HttpStatus.NO_CONTENT, responseTestWrongId.getStatusCode());


        ResponseEntity<Void> response = wizardService.deleteWizard(wizardRepo.findAll().get(wizardRepo.findAll().size()-1).getId());
        assertNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllWizards(){
        Alumni alumni = UtilWizards.createTesti();
        Headmaster headmaster = new Headmaster("Headi", BigDecimal.valueOf(5), "Master");
        wizardRepo.save(alumni);
        wizardRepo.save(headmaster);
        ResponseEntity<List<Wizard>> response = wizardService.getAllWizards(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());

        ResponseEntity<List<Wizard>> responseName = wizardService.getAllWizards("Headi", null);
        assertEquals(1, responseName.getBody().size());
        assertEquals("Headi", responseName.getBody().get(0).getName());

        ResponseEntity<List<Wizard>> responseClass = wizardService.getAllWizards(null, "Alumni");
        assertEquals(1, responseClass.getBody().size());
        assertEquals("Testi", responseClass.getBody().get(0).getName());

    }

    @Test
    public void testGetVoldemort(){
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);

        ResponseEntity<Wizard> responseNoVoldemort = wizardService.getVoldemort("Voldemort");
        assertNull(responseNoVoldemort.getBody());
        assertEquals(HttpStatus.NO_CONTENT, responseNoVoldemort.getStatusCode());

        Voldemort voldemort = new Voldemort("Voldi", BigDecimal.valueOf(10), "Dark");
        wizardRepo.save(voldemort);

        ResponseEntity<Wizard> response = wizardService.getVoldemort("Voldemort");
        assertEquals(voldemort, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllWizardsHp(){
        for (int i = 0; i<5; i++){
            String number = "Test" + i;
            wizardRepo.save(new Alumni(number, BigDecimal.valueOf(i), "Test"));
        }
        ResponseEntity<List<Wizard>> responseMax= wizardService.getAllWizardsHp(2.5, null);
        assertEquals(2, responseMax.getBody().size());
        assertEquals(HttpStatus.OK, responseMax.getStatusCode());

        ResponseEntity<List<Wizard>> responseMin= wizardService.getAllWizardsHp(null, 2.5);
        assertEquals(3, responseMin.getBody().size());
        assertEquals(HttpStatus.OK, responseMin.getStatusCode());
    }

    @Test
    public void testGetAllWizardsVictories(){
        Alumni alumni = UtilWizards.createTesti();
        alumni.setVictories(10);
        Alumni alumni100Victories = new Alumni("Test100", BigDecimal.valueOf(100), "Test100");
        alumni.setVictories(10);
        alumni100Victories.setVictories(100);
        wizardRepo.save(alumni);
        wizardRepo.save(alumni100Victories);

        ResponseEntity<List<Wizard>> response10= wizardService.getAllWizardsVictories(10);
        assertEquals(2, response10.getBody().size());

        ResponseEntity<List<Wizard>> response15= wizardService.getAllWizardsVictories(15);
        assertEquals(1, response15.getBody().size());

        ResponseEntity<List<Wizard>> response101= wizardService.getAllWizardsVictories(101);
        assertEquals(0, response101.getBody().size());

    }

    @Test
    public void testUpdateRating(){
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);

        Headmaster alumniUpdate = new Headmaster("Testi", BigDecimal.valueOf(10), "Test");
        alumniUpdate.setAmount(5);
        alumniUpdate.setRating(BigDecimal.valueOf(3.5));

        ResponseEntity<Wizard> response = wizardService.updateRating(alumniUpdate, alumni.getId());
        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(alumni.getAmount(), alumniUpdate.getAmount());
        assertEquals(alumni.getRating(), alumniUpdate.getRating());

        Headmaster alumniUpdateWrongId = new Headmaster("Testi", BigDecimal.valueOf(10), "Test");
        alumniUpdate.setAmount(50);
        alumniUpdate.setRating(BigDecimal.valueOf(2.5));

        ResponseEntity<Wizard> responseWrongId = wizardService.updateRating(alumniUpdateWrongId, 1000);
        assertEquals(HttpStatus.NO_CONTENT, responseWrongId.getStatusCode());
        assertNull(responseWrongId.getBody());
        assertNotEquals(alumni.getRating(), alumniUpdateWrongId.getRating());
        assertNotEquals(alumni.getAmount(), alumniUpdateWrongId.getAmount());

    }

    @Test
    public void testUpdateVictories(){
        Alumni alumni = UtilWizards.createTesti();
        wizardRepo.save(alumni);

        Headmaster alumniUpdate = new Headmaster("Testi", BigDecimal.valueOf(10), "Test");
        alumniUpdate.setId(alumni.getId());
        alumniUpdate.setVictories(10);

        ResponseEntity<Wizard> response = wizardService.updateVictories(alumniUpdate);

        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alumni.getVictories(), alumniUpdate.getVictories());

        Headmaster alumniUpdateWrongId = new Headmaster("Testi", BigDecimal.valueOf(10), "Test");
        alumniUpdate.setId(1000);
        alumniUpdate.setVictories(50);

        ResponseEntity<Wizard> responseWrongId = wizardService.updateVictories(alumniUpdateWrongId);
        assertEquals(HttpStatus.NO_CONTENT, responseWrongId.getStatusCode());
        assertNull(responseWrongId.getBody());
        assertNotEquals(alumni.getVictories(), alumniUpdateWrongId.getVictories());


    }

    @Test
    public void testCheckName(){
        Alumni alumni = UtilWizards.createTesti();
        Alumni alumni2 = new Alumni("Test2", BigDecimal.valueOf(10), "Test");
        wizardRepo.save(alumni);

        boolean response = wizardService.checkName(alumni);
        boolean responseAnotherWizard = wizardService.checkName(alumni2);

        assertTrue(response);
        assertFalse(responseAnotherWizard);

    }

    @Test
    public void testCheckHouse(){
        Alumni alumni = UtilWizards.createTesti();
        Professor professor = new Professor("Test2", BigDecimal.valueOf(10), "Test");
        wizardRepo.save(alumni);

        boolean response = wizardService.checkHouse(alumni);
        boolean responseAnotherWizard = wizardService.checkHouse(professor);

        assertTrue(response);
        assertFalse(responseAnotherWizard);
    }












}
