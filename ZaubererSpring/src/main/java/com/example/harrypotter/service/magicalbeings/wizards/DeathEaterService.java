package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.DeathEater;
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
public class DeathEaterService {
    private MagicalBeingRepo magicalBeingRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private StrengthAndWeaknessService sawService;
    private WizardService wizardService;
    private HintService hintService;

    public ResponseEntity<Wizard> createDeathEater(DeathEater deathEater) {
        if (wizardService.checkName(deathEater)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        DeathEater de = new DeathEater(deathEater.getName(), deathEater.getHealthPoints(), deathEater.getDescription());
        magicalBeingRepo.save(de);
        conditionService.addConditions(de);

        spellService.createExpelliarmus(de);
        spellService.createStupefy(de);
        spellService.createCalvorio(de);
        spellService.createSectumssempra(de);
        spellService.createAvadaKedavra(de);
        spellService.createImperio(de);
        spellService.createCrucio(de);
        spellService.createFiendfyre(de);
        spellService.createAntiFiendfyre(de);

        potionService.createAntiParalysis(de, 1);
        potionService.createExplodingPotion(de, 2);
        potionService.createRegenerationPotion(de, 1);
        potionService.createWitSharpeningPotion(de, 2);
        potionService.createExtimuloPotion(de, 2);

        animalService.createFlobberworm(de);
        animalService.createPoisonousDuck(de);
        animalService.createTroll(de);
        animalService.createAcromantula(de);
        animalService.createSelma(de);

        sawService.strengthHogwartsHouse(de);

        sawService.weaknessDumbledore(de);
        sawService.weaknessVoldmort(de);
        sawService.weaknessHeadmaster(de);
        sawService.weaknessDeathEater(de);
        sawService.weaknessProfessor(de);
        sawService.weaknessPotionsMaster(de);

        hintService.createBasicHints(de);

        hintService.createTwoTypes(de);
        hintService.createPureblood(de);
        hintService.createFriendshipAndBravery(de);
        hintService.createTimeIsGalleons(de);
        hintService.createKeepingABishop(de);

        return new ResponseEntity<>(de, HttpStatus.OK);
    }
}
