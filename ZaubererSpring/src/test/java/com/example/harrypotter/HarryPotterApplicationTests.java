package com.example.harrypotter;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.wizards.*;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.wizards.WizardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HarryPotterApplicationTests {


    @Autowired
    private WizardRepo wizardRepo;
    @Autowired
    private WizardService wizardService;

//    @Test
//    public void testCheckName(){
//        Dumbledore testWizard = new Dumbledore("TestWizard", BigDecimal.valueOf(99), "Powerful wizard");
//        Dumbledore testWizard2 = new Dumbledore("TestWizard2", BigDecimal.valueOf(1), "Test");
//        wizardRepo.save(testWizard);
//        assertTrue(wizardService.checkName(testWizard));
//        assertFalse(wizardService.checkName(testWizard2));
//    }




}
