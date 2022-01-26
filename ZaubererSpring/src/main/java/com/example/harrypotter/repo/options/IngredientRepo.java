package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {
    List<Ingredient> findAll();
    }
