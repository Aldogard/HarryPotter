package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Potion;
import org.springframework.data.repository.CrudRepository;

public interface PotionsRepo extends CrudRepository<Potion, Integer> {
}
