package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.wizards.Alumni;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.options.OptionsRepo;
import com.example.harrypotter.repo.options.SpellRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.wizards.AlumniService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    private WizardRepo wizardRepo;


    @Test
    public void testCreateExpelliarmus() {
        Alumni alumni = new Alumni("Testi", BigDecimal.valueOf(10), "test");
        wizardRepo.save(alumni);
//        Spell spell = new Spell(
//                "Secret",
//                10.0,
//                10.0,
//                0.0,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                1,
//                null,
//                "");
        spellService.createExpelliarmus(alumni);
        System.out.println(wizardRepo.findByName("Testi").get(0));
//        assertNotNull(wizardRepo.findByName("Testi").get(0).getSpells());
//        assertTrue(alumni.getSpells().size()>0);


    }


}