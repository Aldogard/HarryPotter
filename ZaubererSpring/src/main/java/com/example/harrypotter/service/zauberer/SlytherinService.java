package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.Slytherin;
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
public class SlytherinService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createSlytherin(Slytherin slytherin) {
        if (wizardService.checkName(slytherin)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Slytherin sl = new Slytherin(slytherin.getName(), slytherin.getHealthPoints(), slytherin.getDescription());
        wizardRepo.save(sl);
        conditionService.addConditions(sl);

        optionsService.createExpelliarmus(sl);
        optionsService.createStupefy(sl);
        optionsService.createLevicorpus(sl);
        optionsService.createCalvorio(sl);
        optionsService.createSectumssempra(sl);
        optionsService.createProtego(sl);

        optionsService.createAntiParalysis(sl, 1);
        optionsService.createExplodingPotion(sl, 3);
        optionsService.createHealingPotion(sl, 1);
        optionsService.createInvogiration(sl, 1);
        optionsService.createWitSharpeningPotion(sl ,1);
        optionsService.createExtimuloPotion(sl, 2);

        sawService.weaknessDumbledore(sl);
        sawService.weaknessHeadmaster(sl);
        sawService.weaknessVoldmort(sl);
        sawService.weaknessDeathEater(sl);
        sawService.strengthSlytherin(sl);

        sawService.strengthAlumni(sl);
        sawService.strengthHufflepuff(sl);
        sawService.strengthGryffindor(sl);
        sawService.weaknessPotionsMaster(sl);


        return new ResponseEntity<>(sl, HttpStatus.OK);
    }
}
