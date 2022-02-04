package com.example.harrypotter.entity.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    @Test
    public void testQuestion(){
        Question question = new Question(
                "How much is the fish?"
        );

        assertNotNull(question);
        assertEquals("How much is the fish?", question.getQuestion());
    }
}
