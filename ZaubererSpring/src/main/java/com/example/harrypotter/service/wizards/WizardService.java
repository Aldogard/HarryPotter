package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.magicalbeings.wizards.Headmaster;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public ResponseEntity<Wizard> updateWizard(Headmaster wizard, int id) {
        Wizard updatedWizard = null;
        for (Wizard w : wizardRepo.findAll()) {
            if (w.getName().equals(wizard.getName()) && w.getId() != id) {
                System.out.println("Test");
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }

        for (Wizard w : wizardRepo.findAll()) {
            if (w.getId() == id) {
                w.setId(id);
                w.setName(wizard.getName());
                w.setHealthPoints(wizard.getHealthPoints());
                w.setDescription(wizard.getDescription());
                updatedWizard = wizardRepo.save(w);
            }
        }
        return new ResponseEntity<>(updatedWizard, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteWizard(Integer id) {
        if (wizardRepo.findAll().size() > 5) {
            for (Wizard w : wizardRepo.findAll()) {
                if (w.getId().equals(id)) {
                    wizardRepo.deleteById(id);
                    return new ResponseEntity<>(null, HttpStatus.OK);
                }
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

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

    public ResponseEntity<Wizard> getVoldemort(String voldemort) {
        if (wizardRepo.findByKlasse(voldemort).size() > 0) {
            Wizard lv = wizardRepo.findByKlasse(voldemort).get(0);
            return new ResponseEntity<>(lv, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Wizard>> getAllWizardsHp(Double min, Double max) {
        List<Wizard> wizardList;
        if (min == null) {
            BigDecimal maxBd = BigDecimal.valueOf(max);
            wizardList = wizardRepo.findAll().stream()
                    .filter(zauberer -> zauberer.getHealthPoints().compareTo(maxBd) <= 0)
                    .collect(Collectors.toList());
        } else {
            BigDecimal minBd = BigDecimal.valueOf(min);
            wizardList = wizardRepo.findAll().stream()
                    .filter(zauberer -> zauberer.getHealthPoints().compareTo(minBd) >= 0)
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(wizardList, HttpStatus.OK);
    }

    public ResponseEntity<List<Wizard>> getAllWizardsVictories(Integer victories) {
        List<Wizard> wizardList;
        wizardList = wizardRepo.findAll().stream()
                .filter(zauberer -> zauberer.getVictories().compareTo(victories) >= 0)
                .collect(Collectors.toList());
        return new ResponseEntity<>(wizardList, HttpStatus.OK);
    }

    public ResponseEntity<Wizard> updateRating(Headmaster wizard, int id) {
        Wizard updatedWizard = null;
        for (Wizard w : wizardRepo.findAll()) {
            if (w.getId().equals(id)) {
                w.setAmount(wizard.getAmount());
                w.setRating(wizard.getRating());
                updatedWizard = wizardRepo.save(w);
                return new ResponseEntity<>(updatedWizard, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }


    public ResponseEntity<Wizard> updateVictories(Headmaster wizard) {
        Wizard updatedWizard = null;
        for (Wizard w : wizardRepo.findAll()) {
            if (w.getId().equals(wizard.getId())) {
                w.setVictories(wizard.getVictories());
                w.setRank(wizard.getRank());
                updatedWizard = wizardRepo.save(w);
                return new ResponseEntity<>(updatedWizard, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

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


}



