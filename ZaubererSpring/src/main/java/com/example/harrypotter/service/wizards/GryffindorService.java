package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Gryffindor;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.comments.ConditionService;
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
public class GryffindorService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createGryffindor(Gryffindor gryffindor) {
        if (wizardService.checkName(gryffindor)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Gryffindor gd = new Gryffindor(gryffindor.getName(), gryffindor.getHealthPoints(), gryffindor.getDescription());
        wizardRepo.save(gd);
        conditionService.addConditions(gd);

        spellService.createExpelliarmus(gd);
        spellService.createLevicorpus(gd);
        spellService.createCalvorio(gd);
        spellService.createImmobilus(gd);
        spellService.createProtego(gd);

        potionService.createAntiParalysis(gd, 1);
        potionService.createBrainElixir(gd, 1);
        potionService.createExtimuloPotion(gd, 5);

        animalService.createFlobberworm(gd);

        sawService.strengthDeathEater(gd);
        sawService.strengthHufflepuff(gd);

        sawService.weaknessDumbledore(gd);
        sawService.weaknessVoldmort(gd);
        sawService.weaknessHeadmaster(gd);
        sawService.weaknessProfessor(gd);
        sawService.weaknessRavenclaw(gd);
        sawService.weaknessGryffindor(gd);
        sawService.weaknessPotionsMaster(gd);

        return new ResponseEntity<>(gd, HttpStatus.OK);
    }
}
