package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.wizards.StrengthAndWeakness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaWRepo extends CrudRepository<StrengthAndWeakness, Integer> {
}
