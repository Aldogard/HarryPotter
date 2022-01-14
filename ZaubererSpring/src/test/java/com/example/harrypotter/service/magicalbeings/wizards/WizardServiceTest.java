package com.example.harrypotter.service.magicalbeings.wizards;


import com.example.harrypotter.entity.magicalbeings.wizards.*;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
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
    public void testGetAllWizards(){
        Alumni alumni = UtilWizards.createTesti();
        Headmaster headmaster = new Headmaster("Headi", BigDecimal.valueOf(5), "Master and more than 10");
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
    public void testCheckName(){
        Alumni alumni = UtilWizards.createTesti();
        Alumni alumni2 = new Alumni("Test2", BigDecimal.valueOf(10), "Test  and more than 10");
        wizardRepo.save(alumni);

        boolean response = wizardService.checkName(alumni);
        boolean responseAnotherWizard = wizardService.checkName(alumni2);

        assertTrue(response);
        assertFalse(responseAnotherWizard);

    }

    @Test
    public void testCheckHouse(){
        Alumni alumni = UtilWizards.createTesti();
        Professor professor = new Professor("Test2", BigDecimal.valueOf(10), "Test  and more than 10");
        wizardRepo.save(alumni);

        boolean response = wizardService.checkHouse(alumni);
        boolean responseAnotherWizard = wizardService.checkHouse(professor);

        assertTrue(response);
        assertFalse(responseAnotherWizard);
    }












}
