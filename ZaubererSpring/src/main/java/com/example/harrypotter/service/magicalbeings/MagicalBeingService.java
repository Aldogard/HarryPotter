package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.wizards.Headmaster;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
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
public class MagicalBeingService {
    private MagicalBeingRepo magicalBeingRepo;

    public String quote() {
        Faker faker = new Faker();
        return faker.harryPotter().quote();
    }

    public ResponseEntity<List<MagicalBeing>> getAllMagicalBeings(String name, String klasse) {
        if (name == null && klasse == null) {
            return new ResponseEntity<>(magicalBeingRepo.findAll(), HttpStatus.OK);
        } else if (name != null) {
            return new ResponseEntity<>(magicalBeingRepo.findByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(magicalBeingRepo.findByKlasse(klasse), HttpStatus.OK);
        }
    }

    public ResponseEntity<MagicalBeing> getMagicalBeingById(int id){
        return new ResponseEntity<>(magicalBeingRepo.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<MagicalBeing> updateMagicalBeing(Headmaster magicalBeing, int id) {
        MagicalBeing updateMb = null;
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getName().equals(magicalBeing.getName()) && mb.getId() != id) {
                System.out.println("Test");
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }

        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getId() == id) {
                mb.setId(id);
                mb.setName(magicalBeing.getName());
                mb.setHealthPoints(magicalBeing.getHealthPoints());
                mb.setDescription(magicalBeing.getDescription());
                updateMb = magicalBeingRepo.save(mb);
            }
        }
        return new ResponseEntity<>(updateMb, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMagicalBeing(Integer id) {
        if (magicalBeingRepo.findAll().size() > 5) {
            for (MagicalBeing mb : magicalBeingRepo.findAll()) {
                if (mb.getId().equals(id)) {
                    magicalBeingRepo.deleteById(id);
                    return new ResponseEntity<>(null, HttpStatus.OK);
                }
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<MagicalBeing> getVoldemort(String voldemort) {
        if (magicalBeingRepo.findByKlasse(voldemort).size() > 0) {
            MagicalBeing lv = magicalBeingRepo.findByKlasse(voldemort).get(0);
            return new ResponseEntity<>(lv, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<MagicalBeing>> getAllMagicalBeingHp(Double min, Double max) {
        List<MagicalBeing> magicalBeingList;
        if (min == null) {
            BigDecimal maxBd = BigDecimal.valueOf(max);
            magicalBeingList = magicalBeingRepo.findAll().stream()
                    .filter(mb -> mb.getHealthPoints().compareTo(maxBd) <= 0)
                    .collect(Collectors.toList());
        } else {
            BigDecimal minBd = BigDecimal.valueOf(min);
            magicalBeingList = magicalBeingRepo.findAll().stream()
                    .filter(mb -> mb.getHealthPoints().compareTo(minBd) >= 0)
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(magicalBeingList, HttpStatus.OK);
    }

    public ResponseEntity<List<MagicalBeing>> getAllMagicalBeingsVictories(Integer victories) {
        List<MagicalBeing> magicalBeings;
        magicalBeings = magicalBeingRepo.findAll().stream()
                .filter(mb -> mb.getVictories().compareTo(victories) >= 0)
                .collect(Collectors.toList());
        return new ResponseEntity<>(magicalBeings, HttpStatus.OK);
    }

    public ResponseEntity<MagicalBeing> updateRating(Headmaster magicalBeing, int id) {
        MagicalBeing updatedMb = null;
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getId().equals(id)) {
                mb.setAmount(magicalBeing.getAmount());
                mb.setRating(magicalBeing.getRating());
                updatedMb = magicalBeingRepo.save(mb);
                return new ResponseEntity<>(updatedMb, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<MagicalBeing> updateVictories(Headmaster magicalBeing) {
        MagicalBeing updatedMb = null;
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getId().equals(magicalBeing.getId())) {
                mb.setVictories(magicalBeing.getVictories());
                mb.setRank(magicalBeing.getRank());
                updatedMb = magicalBeingRepo.save(mb);
                return new ResponseEntity<>(updatedMb, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }


    public ResponseEntity<MagicalBeing> getMagicalBeingByName(String name){
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getName().equals(name)) {
                return new ResponseEntity<>(magicalBeingRepo.findById(mb.getId()).orElse(null), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteAllMagicalBeings(){
        magicalBeingRepo.deleteAll(magicalBeingRepo.findAll());
        if (magicalBeingRepo.findAll().size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }



    public boolean checkName(MagicalBeing magicalBeing) {
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getName().equals(magicalBeing.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHouse(MagicalBeing magicalBeing) {
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getClass().equals(magicalBeing.getClass())) {
                return true;
            }
        }
        return false;
    }

}
