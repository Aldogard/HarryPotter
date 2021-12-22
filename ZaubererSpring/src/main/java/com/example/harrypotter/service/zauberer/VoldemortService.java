package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.Voldemort;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.ConditionService;
import com.example.harrypotter.service.options.OptionsService;
import com.example.harrypotter.service.strengthAndWeaknessService.StrengthAndWeaknessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoldemortService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
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

        optionsService.createExpelliarmus(v);
        optionsService.createStupefy(v);
        optionsService.createLevicorpus(v);
        optionsService.createCalvorio(v);
        optionsService.createImmobilus(v);
        optionsService.createSectumssempra(v);
        optionsService.createConfundo(v);
        optionsService.createAvadaKedavra(v);
        optionsService.createImperio(v);
        optionsService.createCrucio(v);
        optionsService.createFiendfyre(v);
        optionsService.createAntiFiendfyre(v);

        optionsService.createAntiParalysis(v, 3);
        optionsService.createExplodingPotion(v, 1);
        optionsService.createUnicornBlood(v, 1);

        sawService.weaknessVoldmort(v);
        sawService.weaknessHeadmaster(v);

        sawService.strengthHogwartsHouse(v);
        sawService.strengthHeadmaster(v);
        sawService.strengthProfessor(v);
        sawService.strengthDeathEater(v);
        sawService.strengthAlumni(v);
        sawService.strengthPotionsMaster(v);


        return new ResponseEntity<>((v), HttpStatus.OK);
    }
}
