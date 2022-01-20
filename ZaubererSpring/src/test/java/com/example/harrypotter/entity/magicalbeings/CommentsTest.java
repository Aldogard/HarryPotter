package com.example.harrypotter.entity.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.CommentsRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentsTest {


    @Test
    public void testComments() {
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test");
        Comments comment = new Comments("Test", test);

        assertNotNull(comment);
        assertEquals("Test", comment.getContent());
        assertEquals(test, comment.getMagicalBeing());


    }
}