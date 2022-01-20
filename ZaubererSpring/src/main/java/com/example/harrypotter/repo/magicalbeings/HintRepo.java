package com.example.harrypotter.repo.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Hint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HintRepo extends CrudRepository<Hint, Integer> {
    List<Hint> findAll();

}
