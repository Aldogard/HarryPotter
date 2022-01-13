package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {

    private OptionsRepo optionsRepo;

    public void createPhoenix(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Fawkes",
                10.0,
                0.0,
                25,
                1.0,
                0.0,
                magicalBeing,
                "Fascinating creatures, phoenixes. They can carry immensely heavy loads, their tears have healing powers, and they make highly faithful pets."
        ));
    }

    public void createFlobberworm(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Flobberworm",
                0.0,
                0.0,
                0,
                0.0,
                0.1,
                magicalBeing,
                "The Flobberworm was a herbivorous, ten-inch, toothless brown magical worm which ate mainly lettuce and cabbage."

        ));
    }


    //Weitere Tiere:
    // Basilisk
    // Poisonous Duck
    // Bowtuckle
    // Dragon --> Hungarian Horntail
    // Fire Crabs
    // Griffin
    // Hippogriff
    // Niffler --> könnte dem Gegner einen Trank stehlen
    // Three-headed Dog
    // Troll
    // möglicherweise noch Wasserwesen, die nur an Wasserorten genutzt werden können
    //


}
