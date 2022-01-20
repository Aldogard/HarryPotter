package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Headmaster;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
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


@Service
@AllArgsConstructor
public class HeadmasterService {
    private WizardRepo wizardRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;
    private HintService hintService;

    public ResponseEntity<Wizard> createHeadmaster(Headmaster headmaster) {
        if (wizardService.checkName(headmaster)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Headmaster hm = new Headmaster(headmaster.getName(), headmaster.getHealthPoints(), headmaster.getDescription());
        wizardRepo.save(hm);
        conditionService.addConditions(hm);

        spellService.createExpelliarmus(hm);
        spellService.createStupefy(hm);
        spellService.createLevicorpus(hm);
        spellService.createCalvorio(hm);
        spellService.createSectumssempra(hm);
        spellService.createConfundo(hm);
        spellService.createImperio(hm);
        spellService.createProtego(hm);

        potionService.createAntiParalysis(hm, 2);
        potionService.createBrainElixir(hm, 1);
        potionService.createExplodingPotion(hm, 3);
        potionService.createHealingPotion(hm, 1);
        potionService.createInvogiration(hm, 1);
        potionService.createWitSharpeningPotion(hm, 2);
        potionService.createExtimuloPotion(hm, 2);

        animalService.createFlobberworm(hm);

        sawService.strengthPotionsMaster(hm);
        sawService.strengthHogwartsHouse(hm);
        sawService.strengthDeathEater(hm);
        sawService.strengthAlumni(hm);

        sawService.weaknessHeadmaster(hm);
        sawService.weaknessDumbledore(hm);

        hintService.createDontMoveThisPiece(hm);
        hintService.createBetterAskRon(hm);

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
}
