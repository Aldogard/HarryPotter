package com.example.harrypotter.service.zauberer;

import com.example.harrypotter.entity.wizards.Gryffindor;
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
public class GryffindorService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
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

        optionsService.createExpelliarmus(gd);
        optionsService.createLevicorpus(gd);
        optionsService.createCalvorio(gd);
        optionsService.createImmobilus(gd);
        optionsService.createProtego(gd);

        optionsService.createAntiParalysis(gd, 1);
        optionsService.createBrainElixir(gd, 1);
        optionsService.createExtimuloPotion(gd, 5);

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
