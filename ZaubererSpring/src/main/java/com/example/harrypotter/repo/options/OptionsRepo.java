package com.example.harrypotter.repo.options;

import com.example.harrypotter.entity.options.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsRepo extends CrudRepository<Options, Integer> {
    List<Options> findAll();
}
