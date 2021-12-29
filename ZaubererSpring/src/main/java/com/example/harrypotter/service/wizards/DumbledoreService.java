package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Dumbledore;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.ConditionService;
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
public class DumbledoreService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
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

        spellService.createExpelliarmus(d);
        spellService.createStupefy(d);
        spellService.createLevicorpus(d);
        spellService.createCalvorio(d);
        spellService.createImmobilus(d);
        spellService.createSectumssempra(d);
        spellService.createConfundo(d);
        spellService.createImperio(d);
        spellService.createProtego(d);
        spellService.createFiendfyre(d);
        spellService.createAntiFiendfyre(d);
        spellService.createFirestorm(d);

        animalService.createFlobberworm(d);

        potionService.createAntiParalysis(d, 2);
        potionService.createBrainElixir(d, 1);
        potionService.createExplodingPotion(d, 3);
        potionService.createHealingPotion(d, 3);
        potionService.createInvogiration(d, 1);
        potionService.createWitSharpeningPotion(d, 2);
        potionService.createExtimuloPotion(d,3);

        sawService.strengthAlumni(d);
        sawService.strengthDeathEater(d);
        sawService.strengthProfessor(d);
        sawService.strengthHogwartsHouse(d);

        sawService.weaknessDumbledore(d);
        sawService.weaknessPotionsMaster(d);



        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}
