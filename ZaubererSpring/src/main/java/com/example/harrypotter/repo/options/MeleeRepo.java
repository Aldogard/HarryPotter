package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Melee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeleeRepo extends CrudRepository<Melee, Integer> {
    List<Melee> findAll();
}
