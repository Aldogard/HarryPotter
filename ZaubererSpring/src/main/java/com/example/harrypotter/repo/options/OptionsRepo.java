package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Options;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OptionsRepo extends CrudRepository<Options, Integer> {
    List<Options> findAll();
}
