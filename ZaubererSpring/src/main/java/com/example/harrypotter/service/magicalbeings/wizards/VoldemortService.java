package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.wizards.Voldemort;
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
public class VoldemortService {
    private MagicalBeingRepo magicalBeingRepo;
    private PotionService potionService;
    private SpellService spellService;
    private AnimalService animalService;
    private ConditionService conditionService;
    private WizardService wizardService;
    private StrengthAndWeaknessService sawService;
    private HintService hintService;


    public ResponseEntity<Wizard> createVoldemort(Voldemort voldemort) {
        if(wizardService.checkName(voldemort)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if(wizardService.checkHouse(voldemort)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Voldemort v = new Voldemort(voldemort.getName(), voldemort.getHealthPoints(), voldemort.getDescription());
        magicalBeingRepo.save(v);
        conditionService.addConditions(v);

        spellService.createExpelliarmus(v);
        spellService.createStupefy(v);
        spellService.createLevicorpus(v);
        spellService.createCalvorio(v);
        spellService.createImmobilus(v);
        spellService.createSectumssempra(v);
        spellService.createConfundo(v);
        spellService.createAvadaKedavra(v);
        spellService.createImperio(v);
        spellService.createCrucio(v);
        spellService.createFiendfyre(v);
        spellService.createAntiFiendfyre(v);

        potionService.createAntiParalysis(v, 3);
        potionService.createExplodingPotion(v, 1);
        potionService.createUnicornBlood(v, 1);

        animalService.createFlobberworm(v);
        animalService.createBasilisk(v);
        animalService.createPoisonousDuck(v);
        animalService.createTroll(v);
        animalService.createAcromantula(v);
        animalService.createSelma(v);

        sawService.strengthHogwartsHouse(v);
        sawService.strengthHeadmaster(v);
        sawService.strengthProfessor(v);
        sawService.strengthDeathEater(v);
        sawService.strengthAlumni(v);
        sawService.strengthPotionsMaster(v);

        sawService.weaknessVoldmort(v);
        sawService.weaknessDumbledore(v);

        hintService.createBasicHints(v);

        hintService.createTwoTypes(v);
        hintService.createPureblood(v);
        hintService.createFriendshipAndBravery(v);

        return new ResponseEntity<>((v), HttpStatus.OK);
    }
}
