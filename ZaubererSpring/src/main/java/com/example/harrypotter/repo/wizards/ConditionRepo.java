package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.wizards.Condition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepo extends CrudRepository<Condition, Integer> {
    List<Condition> findAll();
}
