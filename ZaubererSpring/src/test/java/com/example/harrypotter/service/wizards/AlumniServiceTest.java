package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.wizards.Alumni;

import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumniServiceTest {

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private WizardRepo wizardRepo;

    @AfterEach
    public void deleteAll(){
        wizardRepo.deleteAll();
    }

    @Test
    public void testAlumni() {
        Alumni alumni = new Alumni("Test", BigDecimal.valueOf(10), "test");
        Wizard response = alumniService.createAlumni(alumni).getBody();


        assertNotNull(response);
        assertNotNull(response.getName());
        assertTrue(wizardRepo.findAll().size()>0);
        assertTrue(wizardRepo.findByName("Test").get(0).getId()>0);






    }


}