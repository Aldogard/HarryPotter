package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.DeathEater;
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
public class DeathEaterService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;

    public ResponseEntity<Wizard> createDeathEater(DeathEater deathEater) {
        if (wizardService.checkName(deathEater)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        DeathEater de = new DeathEater(deathEater.getName(), deathEater.getHealthPoints(), deathEater.getDescription());
        wizardRepo.save(de);
        conditionService.addConditions(de);


        optionsService.createExpelliarmus(de);
        optionsService.createStupefy(de);
        optionsService.createCalvorio(de);
        optionsService.createSectumssempra(de);
        optionsService.createAvadaKedavra(de);
        optionsService.createImperio(de);
        optionsService.createCrucio(de);
        optionsService.createFiendfyre(de);
        optionsService.createAntiFiendfyre(de);

        optionsService.createAntiParalysis(de, 1);
        optionsService.createExplodingPotion(de, 2);
        optionsService.createRegenerationPotion(de, 1);
        optionsService.createWitSharpeningPotion(de, 2);
        optionsService.createExtimuloPotion(de, 2);

        sawService.weaknessDumbledore(de);
        sawService.weaknessVoldmort(de);
        sawService.weaknessHeadmaster(de);
        sawService.weaknessDeathEater(de);
        sawService.weaknessProfessor(de);
        sawService.weaknessPotionsMaster(de);

        sawService.strengthHogwartsHouse(de);


        return new ResponseEntity<>(de, HttpStatus.OK);
    }
}
