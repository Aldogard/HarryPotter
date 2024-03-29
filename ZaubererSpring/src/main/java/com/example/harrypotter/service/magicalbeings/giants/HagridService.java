package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.giants.Hagrid;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
import com.example.harrypotter.service.magicalbeings.HintService;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import com.example.harrypotter.service.options.AnimalService;
import com.example.harrypotter.service.options.MeleeService;
import com.example.harrypotter.service.options.PotionService;
import com.example.harrypotter.service.options.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HagridService {

    private MagicalBeingService magicalBeingService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;
    private SpellService spellService;
    private PotionService potionService;
    private AnimalService animalService;
    private HintService hintService;
    private MeleeService meleeService;
    private GiantService giantService;


    public ResponseEntity<Giant> createHalfGiant(Giant halfGiant){
        if (magicalBeingService.checkName(halfGiant)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (giantService.checkHouse(halfGiant)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Hagrid hgNew = new Hagrid(
                halfGiant.getName(),
                halfGiant.getHealthPoints(),
                halfGiant.getDescription());

        magicalBeingRepo.save(hgNew);
        conditionService.addConditions(hgNew);

        spellService.createCalvorio(hgNew);
        spellService.createLevicorpus(hgNew);
        spellService.createConfundo(hgNew);
        spellService.createEpiskey(hgNew);

        potionService.createExtimuloPotion(hgNew, 2);
        potionService.createHealingPotion(hgNew, 1);
        potionService.createInvogiration(hgNew, 1);
        potionService.createExtimuloPotion(hgNew, 2);

        animalService.basicAnimals(hgNew);
        animalService.createHungarianHorntail(hgNew);
        animalService.createGriffin(hgNew);
        animalService.createHippogriff(hgNew);
        animalService.createThreeHeadedDog(hgNew);
        animalService.createAcromantula(hgNew);
        animalService.createGrindelow(hgNew);
        animalService.createKappa(hgNew);
        animalService.createKelpie(hgNew);
        animalService.createSelma(hgNew);

        meleeService.createPunch(hgNew);

        hintService.createBasicHints(hgNew);
        hintService.createKeepingABishop(hgNew);
        hintService.createLikeWizardChess(hgNew);

        return new ResponseEntity<>(hgNew, HttpStatus.OK);
    }
}
