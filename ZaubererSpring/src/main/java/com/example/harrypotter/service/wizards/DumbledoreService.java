package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Dumbledore;
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
public class DumbledoreService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;


    public ResponseEntity<Wizard> createDumbledore(Dumbledore dumbledore) {
        if(wizardService.checkHouse(dumbledore)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (wizardService.checkName(dumbledore)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Dumbledore d = new Dumbledore(dumbledore.getName(), dumbledore.getHealthPoints(), dumbledore.getDescription());

        wizardRepo.save(d);

        conditionService.addConditions(d);

        optionsService.createExpelliarmus(d);
        optionsService.createStupefy(d);

        optionsService.createLevicorpus(d);
        optionsService.createCalvorio(d);
        optionsService.createImmobilus(d);
        optionsService.createSectumssempra(d);
        optionsService.createConfundo(d);
        optionsService.createImperio(d);
        optionsService.createProtego(d);
        optionsService.createFiendfyre(d);
        optionsService.createAntiFiendfyre(d);
        optionsService.createFirestorm(d);

        optionsService.createAntiParalysis(d, 2);
        optionsService.createBrainElixir(d, 1);
        optionsService.createExplodingPotion(d, 3);
        optionsService.createHealingPotion(d, 3);
        optionsService.createInvogiration(d, 1);
        optionsService.createWitSharpeningPotion(d, 2);
        optionsService.createExtimuloPotion(d,3);

        sawService.weaknessDumbledore(d);

        sawService.strengthAlumni(d);
        sawService.strengthDeathEater(d);
        sawService.strengthProfessor(d);
        sawService.strengthHogwartsHouse(d);
        sawService.weaknessPotionsMaster(d);



        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}
