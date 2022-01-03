package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.wizards.Alumni;
import com.example.harrypotter.entity.wizards.Dumbledore;
import com.example.harrypotter.repo.wizards.WizardRepo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class WizardServiceTest {


    @Autowired
    private WizardRepo wizardRepo;

    @Test
    public void testWizardRepo(){
        Alumni alumni = new Alumni("Testi", BigDecimal.valueOf(10), "test");
        wizardRepo.save(alumni);
        assertNotNull(alumni);
        assertTrue(wizardRepo.findAll().size()>0);
    }

}
