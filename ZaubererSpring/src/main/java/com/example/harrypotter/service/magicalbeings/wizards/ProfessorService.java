package com.example.harrypotter.service.magicalbeings.wizards;


import com.example.harrypotter.entity.magicalbeings.wizards.Professor;
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
public class ProfessorService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;

    public ResponseEntity<Wizard> createProfessor(Professor professor) {
        if (wizardService.checkName(professor)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Professor prof = new Professor(professor.getName(), professor.getHealthPoints(), professor.getDescription());
        wizardRepo.save(prof);
        conditionService.addConditions(prof);

        spellService.createExpelliarmus(prof);
        spellService.createStupefy(prof);
        spellService.createLevicorpus(prof);
        spellService.createCalvorio(prof);
        spellService.createImmobilus(prof);
        spellService.createSectumssempra(prof);
        spellService.createConfundo(prof);
        spellService.createImperio(prof);
        spellService.createProtego(prof);
        spellService.createPiertotumLocomotor(prof);

        potionService.createAntiParalysis(prof, 1);
        potionService.createExplodingPotion(prof, 2);
        potionService.createHealingPotion(prof,2);
        potionService.createInvogiration(prof, 2);
        potionService.createExtimuloPotion(prof, 3);

        animalService.createFlobberworm(prof);

        sawService.strengthHogwartsHouse(prof);

        sawService.weaknessHeadmaster(prof);
        sawService.weaknessVoldmort(prof);
        sawService.weaknessProfessor(prof);
        sawService.weaknessDeathEater(prof);

        return new ResponseEntity<>(prof, HttpStatus.OK);
    }
}
