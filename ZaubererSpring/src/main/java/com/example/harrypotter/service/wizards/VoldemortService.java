package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Voldemort;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.ConditionService;
import com.example.harrypotter.service.options.AnimalService;
import com.example.harrypotter.service.options.PotionService;
import com.example.harrypotter.service.options.SpellService;
import com.example.harrypotter.service.strengthAndWeaknessService.StrengthAndWeaknessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoldemortService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createVoldemort(Voldemort voldemort) {
        if(wizardService.checkHouse(voldemort)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (wizardService.checkName(voldemort)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Voldemort v = new Voldemort(voldemort.getName(), voldemort.getHealthPoints(), voldemort.getDescription());
        wizardRepo.save(v);
        conditionService.addConditions(v);

        spellService.createExpelliarmus(v);
        spellService.createStupefy(v);
        spellService.createLevicorpus(v);
        spellService.createCalvorio(v);
        spellService.createImmobilus(v);
        spellService.createSectumssempra(v);
        spellService.createConfundo(v);
        spellService.createAvadaKedavra(v);
        spellService.createImperio(v);
        spellService.createCrucio(v);
        spellService.createFiendfyre(v);
        spellService.createAntiFiendfyre(v);

        potionService.createAntiParalysis(v, 3);
        potionService.createExplodingPotion(v, 1);
        potionService.createUnicornBlood(v, 1);

        animalService.createFlobberworm(v);

        sawService.strengthHogwartsHouse(v);
        sawService.strengthHeadmaster(v);
        sawService.strengthProfessor(v);
        sawService.strengthDeathEater(v);
        sawService.strengthAlumni(v);
        sawService.strengthPotionsMaster(v);

        sawService.weaknessVoldmort(v);
        sawService.weaknessDumbledore(v);

        return new ResponseEntity<>((v), HttpStatus.OK);
    }
}
