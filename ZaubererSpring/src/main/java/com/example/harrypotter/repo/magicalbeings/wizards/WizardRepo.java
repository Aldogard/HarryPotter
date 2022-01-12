package com.example.harrypotter.repo.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WizardRepo extends CrudRepository<Wizard, Integer> {
    List<Wizard> findAll();
    List<Wizard> findByName(String name);
    List<Wizard> findByKlasse(String klasse);


}
