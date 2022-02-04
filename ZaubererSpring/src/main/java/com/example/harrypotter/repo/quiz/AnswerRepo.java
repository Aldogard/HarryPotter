package com.example.harrypotter.repo.quiz;

import com.example.harrypotter.entity.quiz.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Integer> {
    List<Answer> findAll();

}
