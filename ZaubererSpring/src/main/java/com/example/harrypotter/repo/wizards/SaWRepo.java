package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.wizards.StrengthAndWeakness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaWRepo extends CrudRepository<StrengthAndWeakness, Integer> {
    List<StrengthAndWeakness> findAll();
}
