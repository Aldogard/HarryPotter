package com.example.harrypotter.service.magicalbeings.wizards;


import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WizardService {
    private WizardRepo wizardRepo;

    public String quote() {
        Faker faker = new Faker();
        return faker.harryPotter().quote();
    }

    public ResponseEntity<Wizard> getWizardById(Integer id){
        return new ResponseEntity<>(wizardRepo.findById(id).orElse(null), HttpStatus.OK);
    }


    public boolean checkName(Wizard wizard) {
        for (Wizard w : wizardRepo.findAll()) {
            if (w.getName().equals(wizard.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHouse(Wizard wizard) {
        for (Wizard w : wizardRepo.findAll()) {
            if (w.getClass().equals(wizard.getClass())) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<List<Wizard>> getAllWizards(String name, String klasse) {
        if (name == null && klasse == null) {
            return new ResponseEntity<>(wizardRepo.findAll(), HttpStatus.OK);
        } else if (name != null) {
            return new ResponseEntity<>(wizardRepo.findByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(wizardRepo.findByKlasse(klasse), HttpStatus.OK);
        }
    }


}



