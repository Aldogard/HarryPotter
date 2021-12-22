package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.PotionsMaster;
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
public class PotionsMasterService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;

    public ResponseEntity<Wizard> createPotionsMaster(PotionsMaster potionsMaster) {
        if (wizardService.checkName(potionsMaster)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        PotionsMaster pm = new PotionsMaster(potionsMaster.getName(), potionsMaster.getHealthPoints(), potionsMaster.getDescription());
        wizardRepo.save(pm);
        conditionService.addConditions(pm);

        optionsService.createExpelliarmus(pm);
        optionsService.createStupefy(pm);
        optionsService.createCalvorio(pm);
        optionsService.createSectumssempra(pm);
        optionsService.createImperio(pm);

        optionsService.createAntiParalysis(pm, 2);
        optionsService.createBrainElixir(pm, 2);
        optionsService.createExplodingPotion(pm, 3);
        optionsService.createHealingPotion(pm, 3);
        optionsService.createInvogiration(pm, 2);
        optionsService.createWitSharpeningPotion(pm, 2);
        optionsService.createExtimuloPotion(pm, 5);



        sawService.weaknessHeadmaster(pm);
        sawService.weaknessVoldmort(pm);
        sawService.weaknessPotionsMaster(pm);
        sawService.weaknessProfessor(pm);

        sawService.strengthHogwartsHouse(pm);
        sawService.weaknessDeathEater(pm);

        return new ResponseEntity<>(pm, HttpStatus.OK);
    }
}
