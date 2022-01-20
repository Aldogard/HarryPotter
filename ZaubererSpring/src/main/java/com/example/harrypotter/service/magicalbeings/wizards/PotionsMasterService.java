package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.PotionsMaster;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
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
public class PotionsMasterService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
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

        spellService.createExpelliarmus(pm);
        spellService.createStupefy(pm);
        spellService.createCalvorio(pm);
        spellService.createSectumssempra(pm);
        spellService.createImperio(pm);

        potionService.createAntiParalysis(pm, 2);
        potionService.createBrainElixir(pm, 2);
        potionService.createExplodingPotion(pm, 3);
        potionService.createHealingPotion(pm, 3);
        potionService.createInvogiration(pm, 2);
        potionService.createWitSharpeningPotion(pm, 2);
        potionService.createExtimuloPotion(pm, 5);

        animalService.createFlobberworm(pm);

        sawService.strengthHogwartsHouse(pm);

        sawService.weaknessHeadmaster(pm);
        sawService.weaknessVoldmort(pm);
        sawService.weaknessPotionsMaster(pm);
        sawService.weaknessProfessor(pm);
        sawService.weaknessDeathEater(pm);

        return new ResponseEntity<>(pm, HttpStatus.OK);
    }
}
