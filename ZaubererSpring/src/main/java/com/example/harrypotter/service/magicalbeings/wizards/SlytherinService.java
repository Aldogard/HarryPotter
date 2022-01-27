package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Slytherin;
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
public class SlytherinService {
    private MagicalBeingRepo magicalBeingRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;
    private HintService hintService;


    public ResponseEntity<Wizard> createSlytherin(Slytherin slytherin) {
        if (wizardService.checkName(slytherin)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Slytherin sl = new Slytherin(slytherin.getName(), slytherin.getHealthPoints(), slytherin.getDescription());
        magicalBeingRepo.save(sl);
        conditionService.addConditions(sl);

        spellService.createExpelliarmus(sl);
        spellService.createStupefy(sl);
        spellService.createLevicorpus(sl);
        spellService.createCalvorio(sl);
        spellService.createSectumssempra(sl);
        spellService.createProtego(sl);

        potionService.createAntiParalysis(sl, 1);
        potionService.createExplodingPotion(sl, 3);
        potionService.createHealingPotion(sl, 1);
        potionService.createInvogiration(sl, 1);
        potionService.createWitSharpeningPotion(sl ,1);
        potionService.createExtimuloPotion(sl, 2);

        animalService.basicAnimals(sl);

        sawService.strengthAlumni(sl);
        sawService.strengthHufflepuff(sl);
        sawService.strengthGryffindor(sl);

        sawService.weaknessPotionsMaster(sl);
        sawService.weaknessDumbledore(sl);
        sawService.weaknessHeadmaster(sl);
        sawService.weaknessVoldmort(sl);
        sawService.weaknessDeathEater(sl);
        sawService.weaknessSlytherin(sl);

        hintService.createBasicHints(sl);

        hintService.createTwoTypes(sl);
        hintService.createPureblood(sl);
        hintService.createLikeWizardChess(sl);
        hintService.createFriendshipAndBravery(sl);
        hintService.createTimeIsGalleons(sl);
        hintService.createKeepingABishop(sl);
        hintService.createBlunderingPieces(sl);

        return new ResponseEntity<>(sl, HttpStatus.OK);
    }
}
