package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Ravenclaw;
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
public class RavenclawService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createRavenclaw(Ravenclaw raven) {
        if (wizardService.checkName(raven)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Ravenclaw rc = new Ravenclaw(raven.getName(), raven.getHealthPoints(), raven.getDescription());
        wizardRepo.save(rc);
        conditionService.addConditions(rc);

        optionsService.createExpelliarmus(rc);
        optionsService.createStupefy(rc);
        optionsService.createLevicorpus(rc);
        optionsService.createCalvorio(rc);
        optionsService.createImmobilus(rc);
        optionsService.createConfundo(rc);
        optionsService.createProtego(rc);
        optionsService.createPiertotumLocomotor(rc);

        optionsService.createAntiParalysis(rc, 2);
        optionsService.createBrainElixir(rc, 2);
        optionsService.createExplodingPotion(rc, 1);
        optionsService.createHealingPotion(rc, 1);
        optionsService.createInvogiration(rc, 1);
        optionsService.createExtimuloPotion(rc, 2);

        sawService.weaknessDumbledore(rc);
        sawService.weaknessHeadmaster(rc);
        sawService.weaknessVoldmort(rc);
        sawService.weaknessRavenclaw(rc);
        sawService.weaknessPotionsMaster(rc);


        sawService.strengthGryffindor(rc);
        sawService.strengthSlytherin(rc);
        sawService.strengthHufflepuff(rc);

        return new ResponseEntity<>(rc, HttpStatus.OK);
    }
}
