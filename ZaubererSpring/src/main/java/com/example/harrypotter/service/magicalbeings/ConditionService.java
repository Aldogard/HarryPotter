package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.dummy.ConditionDummy;
import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.dummy.Dummy;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.dummy.ConditionDummyRepo;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConditionService {
    private ConditionRepo conditionRepo;
    private ConditionDummyRepo conditionDummyRepo;

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

    public void addConditionsDummy(Dummy dummy){
        ConditionDummy confunded = new ConditionDummy(dummy, "Confunded");
        ConditionDummy stunned = new ConditionDummy(dummy, "Stunned");

        conditionDummyRepo.save(confunded);
        conditionDummyRepo.save(stunned);
    }
}
