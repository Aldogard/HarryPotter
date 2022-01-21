package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
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

import java.awt.*;


@Service
@AllArgsConstructor
public class AlumniService {
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;
    private HintService hintService;
    private MagicalBeingRepo magicalBeingRepo;

    public ResponseEntity<Wizard> createAlumni(Alumni alumni) {
        if (wizardService.checkName(alumni)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Alumni a = new Alumni(alumni.getName(), alumni.getHealthPoints(), alumni.getDescription());
        magicalBeingRepo.save(a);
        conditionService.addConditions(a);

        spellService.createExpelliarmus(a);
        spellService.createLevicorpus(a);
        spellService.createCalvorio(a);
        spellService.createImmobilus(a);
        spellService.createSectumssempra(a);
        spellService.createImperio(a);
        spellService.createProtego(a);

        potionService.createAntiParalysis(a, 1);
        potionService.createExplodingPotion(a, 2);
        potionService.createRegenerationPotion(a, 1);
        potionService.createHealingPotion(a, 1);
        potionService.createWitSharpeningPotion(a, 1);
        potionService.createExtimuloPotion(a, 3);

        animalService.createFlobberworm(a);

        sawService.strengthHogwartsHouse(a);

        sawService.weaknessDumbledore(a);
        sawService.weaknessVoldmort(a);
        sawService.weaknessAlumni(a);
        sawService.weaknessProfessor(a);
        sawService.weaknessHeadmaster(a);
        sawService.weaknessPotionsMaster(a);

        hintService.createBasicHints(a);

        hintService.createDecision(a);
        hintService.createUnknown(a);
        hintService.createTwoTypes(a);
        hintService.createPawnPush(a);
        hintService.createSendToAzkaban(a);
        hintService.createEveryPawn(a);
        hintService.createNotAGoodSign(a);



        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
