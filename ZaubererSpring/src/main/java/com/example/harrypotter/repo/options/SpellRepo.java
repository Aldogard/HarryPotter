package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Spell;
import org.springframework.data.repository.CrudRepository;

public interface SpellRepo extends CrudRepository<Spell, Integer> {
}
