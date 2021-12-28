package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {

    private OptionsRepo optionsRepo;

    public void createPhoenix(Wizard wizard) {
        optionsRepo.save(new Animal(
                "Fawkes",
                10.0,
                0.0,
                25,
                1.0,
                0.0,
                wizard,
                "Fascinating creatures, phoenixes. They can carry immensely heavy loads, their tears have healing powers, and they make highly faithful pets."
        ));
    }

    public void createFlobberworm(Wizard wizard) {
        optionsRepo.save(new Animal(
                "Flobberworm",
                0.0,
                0.0,
                0,
                0.0,
                0.1,
                wizard,
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
