package com.example.harrypotter.service;

import com.example.harrypotter.entity.dummy.Dummy;
import com.example.harrypotter.repo.dummy.DummyRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DummyService {
    private DummyRepo dummyRepo;
    private ConditionService conditionService;


    public ResponseEntity<Dummy> createDummy() {
        Dummy d = new Dummy();
        dummyRepo.save(d);
        conditionService.addConditionsDummy(d);

        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    public ResponseEntity<Dummy> getDummyByName(String name) {
        for (Dummy d : dummyRepo.findAll()) {
            if (d.getName().equals(name)) {
                return new ResponseEntity<>(dummyRepo.findById(d.getId()).orElse(null), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteAllDummy() {
        dummyRepo.deleteAll(dummyRepo.findAll());
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
