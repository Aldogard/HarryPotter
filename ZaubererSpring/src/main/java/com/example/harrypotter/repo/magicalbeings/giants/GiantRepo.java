package com.example.harrypotter.repo.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiantRepo extends CrudRepository<Giant, Integer> {
    List<Giant> findAll();

}
