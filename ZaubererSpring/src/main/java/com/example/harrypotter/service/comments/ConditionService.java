package com.example.harrypotter.service.comments;

import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.wizards.ConditionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConditionService {
    private ConditionRepo conditionRepo;

    public void addConditions(Wizard zauberer){
        Condition confunded = new Condition(zauberer, "Confunded");
        Condition stunned = new Condition(zauberer, "Stunned");

        conditionRepo.save(confunded);
        conditionRepo.save(stunned);
    }
}
