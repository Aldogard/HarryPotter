package com.example.harrypotter.entity.quiz;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    @Test
    public void testAnswer(){
        Question question = new Question();
        Answer answer = new Answer(
                "Sirius Black",
                true,
                question
        );

        assertNotNull(answer);
        assertEquals("Sirius Black", answer.getAnswer());
        assertTrue(answer.correct);
        assertEquals(question, answer.getQuestion());
    }
}
