package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Hufflepuff;
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
public class HufflepuffService {

    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createHufflepuff(Hufflepuff hufflepuff) {
        if (wizardService.checkName(hufflepuff)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Hufflepuff hp = new Hufflepuff(hufflepuff.getName(), hufflepuff.getHealthPoints(), hufflepuff.getDescription());
        wizardRepo.save(hp);
        conditionService.addConditions(hp);

        optionsService.createExpelliarmus(hp);
        optionsService.createLevicorpus(hp);
        optionsService.createCalvorio(hp);
        optionsService.createImmobilus(hp);
        optionsService.createConfundo(hp);
        optionsService.createProtego(hp);

        optionsService.createBrainElixir(hp,1);
        optionsService.createAntiParalysis(hp, 3);
        optionsService.createHealingPotion(hp, 1);
        optionsService.createExtimuloPotion(hp, 3);

        sawService.weaknessDumbledore(hp);
        sawService.weaknessVoldmort(hp);
        sawService.weaknessProfessor(hp);
        sawService.weaknessAlumni(hp);
        sawService.weaknessDeathEater(hp);
        sawService.weaknessHufflepuff(hp);
        sawService.strengthPotionsMaster(hp);

        sawService.strengthSlytherin(hp);
        sawService.strengthGryffindor(hp);

        return new ResponseEntity<>(hp, HttpStatus.OK);
    }
}
