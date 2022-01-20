package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.repo.magicalbeings.HintRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HintService {
    private HintRepo hintRepo;

    public void createDontMoveThisPiece(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
           "I would move a different piece",
           false,
           false,
           magicalBeing
        ));
    }

    public void createBetterAskRon(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You should ask Ron for help, your position is a catastrophe",
                false,
                true,
                magicalBeing
        ));
    }




}
