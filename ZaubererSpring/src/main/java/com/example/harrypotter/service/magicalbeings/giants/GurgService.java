package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
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
public class GurgService {
    private MagicalBeingService magicalBeingService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;
    private SpellService spellService;
    private PotionService potionService;
    private AnimalService animalService;
    private HintService hintService;
    private MeleeService meleeService;


        public ResponseEntity<Giant> createGurg(Gurg gurg){
        if (magicalBeingService.checkName(gurg)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Gurg gurgNew = new Gurg(
                gurg.getName(),
                gurg.getHealthPoints(),
                gurg.getDescription());

        magicalBeingRepo.save(gurgNew);
        conditionService.addConditions(gurgNew);

        spellService.createCalvorio(gurgNew);

        potionService.createExplodingPotion(gurgNew, 2);
        potionService.createHealingPotion(gurgNew, 1);
        potionService.createExtimuloPotion(gurgNew, 1);

        animalService.createFlobberworm(gurgNew);
        animalService.createHungarianHorntail(gurgNew);
        animalService.createFireCrabs(gurgNew);
        animalService.createThreeHeadedDog(gurgNew);

        meleeService.createGurgAttack(gurgNew);
        meleeService.createPunch(gurgNew);

        hintService.createBasicHints(gurgNew);

        return new ResponseEntity<>(gurgNew, HttpStatus.OK);
    }
}
