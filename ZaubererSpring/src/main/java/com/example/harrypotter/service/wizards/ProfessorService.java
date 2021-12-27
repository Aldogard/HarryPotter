package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.wizards.Professor;
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
public class ProfessorService {
    private WizardRepo wizardRepo;
    private OptionsService optionsService;
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

        optionsService.createExpelliarmus(prof);
        optionsService.createStupefy(prof);
        optionsService.createLevicorpus(prof);
        optionsService.createCalvorio(prof);
        optionsService.createImmobilus(prof);
        optionsService.createSectumssempra(prof);
        optionsService.createConfundo(prof);
        optionsService.createImperio(prof);
        optionsService.createProtego(prof);
        optionsService.createPiertotumLocomotor(prof);

        optionsService.createAntiParalysis(prof, 1);
        optionsService.createExplodingPotion(prof, 2);
        optionsService.createHealingPotion(prof,2);
        optionsService.createInvogiration(prof, 2);
        optionsService.createExtimuloPotion(prof, 3);

        sawService.weaknessHeadmaster(prof);
        sawService.weaknessVoldmort(prof);
        sawService.weaknessProfessor(prof);

        sawService.strengthHogwartsHouse(prof);
        sawService.weaknessDeathEater(prof);

        return new ResponseEntity<>(prof, HttpStatus.OK);
    }
}
