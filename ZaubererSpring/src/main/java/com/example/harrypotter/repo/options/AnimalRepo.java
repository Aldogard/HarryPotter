package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Integer> {
}
