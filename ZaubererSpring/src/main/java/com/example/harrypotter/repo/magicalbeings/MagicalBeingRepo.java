package com.example.harrypotter.repo.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagicalBeingRepo extends CrudRepository<MagicalBeing, Integer> {
    List<MagicalBeing> findAll();
}
