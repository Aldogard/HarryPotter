package com.example.harrypotter.repo.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.StrengthAndWeakness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrengthAndWeaknessRepo extends CrudRepository<StrengthAndWeakness, Integer> {
    List<StrengthAndWeakness> findAll();
}
