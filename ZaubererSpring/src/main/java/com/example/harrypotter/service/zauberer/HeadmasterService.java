package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.Headmaster;
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
public class HeadmasterService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;

    public ResponseEntity<Wizard> createHeadmaster(Headmaster headmaster) {
        if (wizardService.checkName(headmaster)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Headmaster hm = new Headmaster(headmaster.getName(), headmaster.getHealthPoints(), headmaster.getDescription());
        wizardRepo.save(hm);
        conditionService.addConditions(hm);

        optionsService.createExpelliarmus(hm);
        optionsService.createStupefy(hm);
        optionsService.createLevicorpus(hm);
        optionsService.createCalvorio(hm);
        optionsService.createSectumssempra(hm);
        optionsService.createConfundo(hm);
        optionsService.createImperio(hm);
        optionsService.createProtego(hm);

        optionsService.createAntiParalysis(hm, 2);
        optionsService.createBrainElixir(hm, 1);
        optionsService.createExplodingPotion(hm, 3);
        optionsService.createHealingPotion(hm, 1);
        optionsService.createInvogiration(hm, 1);
        optionsService.createWitSharpeningPotion(hm, 2);
        optionsService.createExtimuloPotion(hm, 2);

        sawService.weaknessHeadmaster(hm);
        sawService.weaknessDumbledore(hm);

        sawService.strengthHogwartsHouse(hm);
        sawService.strengthDeathEater(hm);
        sawService.strengthAlumni(hm);
        sawService.strengthPotionsMaster(hm);

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
}
