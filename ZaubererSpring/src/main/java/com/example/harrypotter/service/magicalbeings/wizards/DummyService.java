package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import com.example.harrypotter.entity.magicalbeings.wizards.Dummy;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DummyService {
    private WizardService wizardService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;


    public ResponseEntity<Wizard> createDummy(Dummy dummy) {
        if (wizardService.checkHouse(dummy)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Dummy d = new Dummy(dummy.getName(), dummy.getHealthPoints(), dummy.getDescription());
        magicalBeingRepo.save(d);
        conditionService.addConditions(d);

        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}
