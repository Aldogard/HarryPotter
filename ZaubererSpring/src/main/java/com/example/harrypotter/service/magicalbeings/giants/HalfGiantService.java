package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.giants.HalfGiant;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.comments.ConditionService;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import com.example.harrypotter.service.options.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HalfGiantService {

    private MagicalBeingService magicalBeingService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;
    private SpellService spellService;


    public ResponseEntity<Giant> createHalfGiant(HalfGiant halfGiant){
        if (magicalBeingService.checkName(halfGiant)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HalfGiant hgNew = new HalfGiant(
                halfGiant.getName(),
                halfGiant.getHealthPoints(),
                halfGiant.getDescription());
        magicalBeingRepo.save(hgNew);
        conditionService.addConditions(hgNew);

        spellService.createCalvorio(hgNew);

        return new ResponseEntity<>(hgNew, HttpStatus.OK);
    }
}
