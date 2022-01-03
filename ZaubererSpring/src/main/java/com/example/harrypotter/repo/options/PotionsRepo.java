package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Options;
import com.example.harrypotter.entity.options.Potion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotionsRepo extends CrudRepository<Potion, Integer> {
    List<Potion> findAll();

}
