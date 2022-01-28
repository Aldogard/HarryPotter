package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.options.Melee;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MeleeService {
    private OptionsRepo optionsRepo;

    public void createGurgAttack(MagicalBeing magicalBeing){
        optionsRepo.save(new Melee(
                "Gurg Attack",
                25.0,
                40.0,
                5,
                true,
                false,
                magicalBeing,
                "Powerful punch with overwhelming raw strength. Knocks out the recipient"
        ));
    }

    public void createPunch(MagicalBeing magicalBeing){
        optionsRepo.save(new Melee(
                "Punch",
                10.0,
                15.0,
                0,
                false,
                true,
                magicalBeing,
                "Powerful punch that harms and confounds the opponent"
        ));
    }
}
