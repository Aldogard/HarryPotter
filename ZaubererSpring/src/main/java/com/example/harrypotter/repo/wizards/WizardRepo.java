package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.wizards.Wizard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WizardRepo extends CrudRepository<Wizard, Integer> {
    List<Wizard> findAll();
    List<Wizard> findByName(String name);
    List<Wizard> findByKlasse(String klasse);


}
