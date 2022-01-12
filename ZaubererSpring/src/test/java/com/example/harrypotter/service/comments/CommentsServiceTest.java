package com.example.harrypotter.service.comments;

import com.example.harrypotter.controller.CommentsController;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.repo.magicalbeings.CommentsRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CommentsServiceTest {

    @Autowired
    private CommentsRepo commentsRepo;

    @Autowired
    private WizardRepo wizardRepo;

    @Autowired
    private CommentsService commentsService;

    @Autowired CommentsController commentsController;

    @AfterEach
    public void deleteAll(){
        wizardRepo.deleteAll();
        commentsRepo.deleteAll();
    }

    @Test
    public void testCreateComment() {
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test  and more than 10");
        wizardRepo.save(test);
        Comments comment = new Comments("Test and more than 10", test);

        ResponseEntity<Comments> response = commentsService.createComment(comment, test.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comment.getClass(), response.getBody().getClass());
        assertNotNull(commentsRepo.findAll());
        assertNotNull(response.getBody().getId());


    }

    @Test
    public void testPostComment(){
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test  and more than 10");
        wizardRepo.save(test);
        Comments comment = new Comments("Test and more than 10", test);

        ResponseEntity<Comments> response = commentsController.createComment(comment, test.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comment.getClass(), response.getBody().getClass());
        assertNotNull(commentsRepo.findAll());
        assertNotNull(response.getBody().getId());
    }


}
