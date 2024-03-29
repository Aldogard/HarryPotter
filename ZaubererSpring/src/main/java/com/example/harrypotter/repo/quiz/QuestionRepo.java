package com.example.harrypotter.repo.quiz;

import com.example.harrypotter.entity.quiz.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer> {
    List<Question> findAll();

}
