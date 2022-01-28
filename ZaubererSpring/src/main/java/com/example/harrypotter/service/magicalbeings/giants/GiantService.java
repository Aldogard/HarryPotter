package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.giants.GiantRepo;
import com.example.harrypotter.service.magicalbeings.ConditionService;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import com.example.harrypotter.service.options.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GiantService {
    private MagicalBeingService magicalBeingService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;
    private SpellService spellService;
    private GiantRepo giantRepo;

    public boolean checkHouse(Giant giant) {
        for (Giant g : giantRepo.findAll()) {
            if (g.getClass().equals(giant.getClass())) {
                return true;
            }
        }
        return false;
    }


//    public ResponseEntity<Giant> createGiant(Giant giant){
//        if (magicalBeingService.checkName(giant)) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//        Giant giantNew = new Giant(
//                giant.getName(),
//                giant.getHealthPoints(),
//                giant.getDescription());
//        magicalBeingRepo.save(giantNew);
//        conditionService.addConditions(giantNew);
//
//        spellService.createCalvorio(giantNew);
//
//        return new ResponseEntity<>(giantNew, HttpStatus.OK);
//    }


}
