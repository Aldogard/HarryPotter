package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Alumni;
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
public class AlumniService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;

    public ResponseEntity<Wizard> createAlumni(Alumni alumni) {
        if (wizardService.checkName(alumni)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Alumni a = new Alumni(alumni.getName(), alumni.getHealthPoints(), alumni.getDescription());
        wizardRepo.save(a);
        conditionService.addConditions(a);

        optionsService.createExpelliarmus(a);
        optionsService.createLevicorpus(a);
        optionsService.createCalvorio(a);
        optionsService.createImmobilus(a);
        optionsService.createSectumssempra(a);
        optionsService.createImperio(a);
        optionsService.createProtego(a);


        optionsService.createAntiParalysis(a, 1);
        optionsService.createExplodingPotion(a, 2);
        optionsService.createRegenerationPotion(a, 1);
        optionsService.createHealingPotion(a, 1);
        optionsService.createWitSharpeningPotion(a, 1);
        optionsService.createExtimuloPotion(a, 3);

        sawService.weaknessDumbledore(a);
        sawService.weaknessVoldmort(a);
        sawService.weaknessAlumni(a);
        sawService.weaknessProfessor(a);
        sawService.weaknessHeadmaster(a);
        sawService.weaknessPotionsMaster(a);

        sawService.strengthHogwartsHouse(a);


        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
