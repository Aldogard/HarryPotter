package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.giants.GiantRepo;
import com.example.harrypotter.service.comments.ConditionService;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GiantService {
    private MagicalBeingService magicalBeingService;
    private MagicalBeingRepo magicalBeingRepo;
    private ConditionService conditionService;


    public ResponseEntity<Giant> createGiant(Giant giant){
        if (magicalBeingService.checkName(giant)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Giant giantNew = new Giant(
                giant.getName(),
                giant.getHealthPoints(),
                giant.getDescription());
        magicalBeingRepo.save(giantNew);
        conditionService.addConditions(giantNew);

        return new ResponseEntity<>(giantNew, HttpStatus.OK);
    }


}
