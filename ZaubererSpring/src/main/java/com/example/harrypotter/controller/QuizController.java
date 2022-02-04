package com.example.harrypotter.controller;

import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.entity.quiz.Question;
import com.example.harrypotter.repo.quiz.AnswerRepo;
import com.example.harrypotter.repo.quiz.QuestionRepo;
import com.example.harrypotter.service.QuizService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;
    private QuestionRepo questionRepo;
    private AnswerRepo answerRepo;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Question>> getAllQuestions() {
        quizService.createAllQuestions();
        return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteAllQuestions() {
        questionRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
