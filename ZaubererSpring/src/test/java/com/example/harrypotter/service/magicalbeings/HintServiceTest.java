package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.HintRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class HintServiceTest {
    @Autowired
    private HintRepo hintRepo;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private HintService hintService;


    @AfterEach
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
        hintRepo.deleteAll();
    }

    private Hint checkSavingOfHint(){
        assertNotNull(hintRepo.findAll());
        assertEquals(1, hintRepo.findAll().size());
        return hintRepo.findAll().get(0);
    }

    @Test
    public void testCreateDontMoveThisPiece(){
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test  and more than 10");
        magicalBeingRepo.save(test);
        hintService.createDontMoveThisPiece(test);

        Hint hint = checkSavingOfHint();
        assertEquals("I would move a different piece", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertEquals(test, hint.getMagicalBeing());
    }


}
