package com.example.harrypotter.service.magicalbeings.wizards;


import com.example.harrypotter.entity.magicalbeings.wizards.Professor;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
import com.example.harrypotter.service.magicalbeings.HintService;
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
    private MagicalBeingRepo magicalBeingRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;
    private HintService hintService;

    public ResponseEntity<Wizard> createProfessor(Professor professor) {
        if (wizardService.checkName(professor)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Professor prof = new Professor(professor.getName(), professor.getHealthPoints(), professor.getDescription());
        magicalBeingRepo.save(prof);
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
        animalService.createPoisonousDuck(prof);
        animalService.createBowtuckle(prof);
        animalService.createHippogriff(prof);
        animalService.createNiffler(prof);


        sawService.strengthHogwartsHouse(prof);

        sawService.weaknessHeadmaster(prof);
        sawService.weaknessVoldmort(prof);
        sawService.weaknessProfessor(prof);
        sawService.weaknessDeathEater(prof);

        hintService.createBasicHints(prof);

        hintService.createNotARavenclaw(prof);
        hintService.createDecision(prof);
        hintService.createTwoTypes(prof);
        hintService.createTimeIsGalleons(prof);
        hintService.createPawnPush(prof);
        hintService.createInaccuraciesAndMistakes(prof);
        hintService.createDwellOnTactics(prof);

        return new ResponseEntity<>(prof, HttpStatus.OK);
    }
}
