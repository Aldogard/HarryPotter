package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Ravenclaw;
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
public class RavenclawService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
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

        spellService.createExpelliarmus(rc);
        spellService.createStupefy(rc);
        spellService.createLevicorpus(rc);
        spellService.createCalvorio(rc);
        spellService.createImmobilus(rc);
        spellService.createConfundo(rc);
        spellService.createProtego(rc);
        spellService.createPiertotumLocomotor(rc);

        potionService.createAntiParalysis(rc, 2);
        potionService.createBrainElixir(rc, 2);
        potionService.createExplodingPotion(rc, 1);
        potionService.createHealingPotion(rc, 1);
        potionService.createInvogiration(rc, 1);
        potionService.createExtimuloPotion(rc, 2);

        animalService.createFlobberworm(rc);

        sawService.strengthGryffindor(rc);
        sawService.strengthSlytherin(rc);
        sawService.strengthHufflepuff(rc);

        sawService.weaknessDumbledore(rc);
        sawService.weaknessHeadmaster(rc);
        sawService.weaknessVoldmort(rc);
        sawService.weaknessRavenclaw(rc);
        sawService.weaknessPotionsMaster(rc);


        return new ResponseEntity<>(rc, HttpStatus.OK);
    }
}
