package com.example.harrypotter.service.zauberer;


import com.example.harrypotter.entity.wizards.Dumbledore;
import com.example.harrypotter.repo.wizards.WizardRepo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AllArgsConstructor
public class WizardServiceTest {

    private WizardService wizardService;
    private WizardRepo wizardRepo;


    @Test
    public void testCheckName(){
        Dumbledore testWizard = new Dumbledore("TestWizard", BigDecimal.valueOf(99), "Powerful wizard");
        Dumbledore testWizard2 = new Dumbledore("TestWizard2", BigDecimal.valueOf(1), "Test");
        wizardRepo.save(testWizard);
        assertTrue(wizardService.checkName(testWizard));
        assertFalse(wizardService.checkName(testWizard2));

        wizardService.deleteWizard(testWizard.getId());
    }
}
