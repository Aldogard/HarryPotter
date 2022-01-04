package com.example.harrypotter.service.wizards;

import com.example.harrypotter.entity.wizards.Hufflepuff;
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
public class HufflepuffService {

    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
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

        spellService.createExpelliarmus(hp);
        spellService.createLevicorpus(hp);
        spellService.createCalvorio(hp);
        spellService.createImmobilus(hp);
        spellService.createConfundo(hp);
        spellService.createProtego(hp);

        potionService.createBrainElixir(hp,1);
        potionService.createAntiParalysis(hp, 3);
        potionService.createHealingPotion(hp, 1);
        potionService.createExtimuloPotion(hp, 3);

        animalService.createFlobberworm(hp);

        sawService.strengthSlytherin(hp);
        sawService.strengthGryffindor(hp);

        sawService.weaknessDumbledore(hp);
        sawService.weaknessVoldmort(hp);
        sawService.weaknessProfessor(hp);
        sawService.weaknessAlumni(hp);
        sawService.weaknessDeathEater(hp);
        sawService.weaknessHufflepuff(hp);
        sawService.weaknessPotionsMaster(hp);

        return new ResponseEntity<>(hp, HttpStatus.OK);
    }
}
