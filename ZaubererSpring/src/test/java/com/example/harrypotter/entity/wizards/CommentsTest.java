package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.wizards.CommentsRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CommentsTest {

    @Autowired
    private CommentsRepo commentsRepo;

    @Autowired
    private WizardRepo wizardRepo;

    @Test
    public void testComments() {
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test");
        wizardRepo.save(test);

//        Comments comment = new Comments("Test", test);
//        commentsRepo.save(comment);
//
//        assertNotNull(commentsRepo.findAll());
//        assertNotNull(comment.getId());


    }
}