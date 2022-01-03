package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Options;
import com.example.harrypotter.entity.options.Spell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellRepo extends CrudRepository<Spell, Integer> {
    List<Spell> findAll();

}
