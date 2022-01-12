package com.example.harrypotter.service.comments;

import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import com.example.harrypotter.repo.magicalbeings.giants.GiantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConditionService {
    private ConditionRepo conditionRepo;

    public void addConditions(Wizard wizard){
        Condition confunded = new Condition(wizard, "Confunded");
        Condition stunned = new Condition(wizard, "Stunned");

        conditionRepo.save(confunded);
        conditionRepo.save(stunned);
    }

    public void addConditions(Giant giant){
        Condition confunded = new Condition(giant, "Confunded");
        Condition stunned = new Condition(giant, "Stunned");

        conditionRepo.save(confunded);
        conditionRepo.save(stunned);
    }
}
