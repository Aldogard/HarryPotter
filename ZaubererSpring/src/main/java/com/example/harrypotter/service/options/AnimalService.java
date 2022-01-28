package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {

    private OptionsRepo optionsRepo;

    public void basicAnimals(MagicalBeing magicalBeing) {
        createFlobberworm(magicalBeing);
        createPoisonousDuck(magicalBeing);
        createBowtuckle(magicalBeing);
        createFireCrabs(magicalBeing);
        createNiffler(magicalBeing);
    }

    public void createPhoenix(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Fawkes",
                10.0,
                0.0,
                25,
                1.0,
                0.0,
                false,
                false,
                magicalBeing,
                "Fascinating creatures, phoenixes. They can carry immensely heavy loads, " +
                        "their tears have healing powers, and they make highly faithful pets."
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
                false,
                false,
                magicalBeing,
                "The Flobberworm was a herbivorous, ten-inch, toothless brown magical " +
                        "worm which ate mainly lettuce and cabbage."

        ));
    }

    public void createBasilisk(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Basilisk",
                25.0,
                50.0,
                30,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "Of the many fearsome beasts and monsters that roam our land, " +
                        "there is none more curious or more deadly than the Basilisk, " +
                        "known also as the King of Serpents. "
        ));
    }

    public void createPoisonousDuck(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Poisonous duck",
                2.0,
                5.0,
                0,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "A poisonous duck is some sort of magical creature bred at the British Ministry of Magic."
        ));
    }

    public void createBowtuckle(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Bowtuckle",
                1.0,
                3.0,
                0,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "The Bowtruckle, which eats insects, is a peaceable and intensely shy creature."

        ));
    }

    public void createHungarianHorntail(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Hungarian Horntail",
                25.0,
                40.0,
                25,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "Supposedly the most dangerous of all dragon breeds, " +
                        "the Hungarian Horntail has black scales and is lizard-like in appearance."
        ));
    }

    public void createFireCrabs(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Fire crab",
                5.0,
                10.0,
                15,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "Despite its name, the Fire Crab greatly resembles a large tortoise with a heavily jewelled shell."
        ));
    }

    public void createGriffin(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Griffin",
                10.0,
                15.0,
                10,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "The Griffin is a magical beast which originated from Greece. " +
                        "It has the front legs, wings and head of a giant eagle, " +
                        "and the body, hind legs, and tail of a lion."
        ));
    }

    public void createHippogriff(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Hippogriff",
                12.0,
                20.0,
                15,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "Half horse, half eagle creatures, immensely proud and extremely dangerous."
        ));
    }

    public void createNiffler(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Niffler",
                5.0,
                0.0,
                10,
                0.0,
                0.0,
                true,
                false,
                magicalBeing,
                "Long-snouted, burrowing creatures native to Britain with a penchant for anything shiny."
        ));
    }

    public void createThreeHeadedDog(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Fluffy",
                15.0,
                25.0,
                20,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "It has three heads. Three pairs of rolling, mad eyes; three noses, " +
                        "twitching and quivering in their direction; three drooling mouths, " +
                        "saliva hanging in slippery ropes from yellowish fangs."
        ));
    }

    public void createTroll(MagicalBeing magicalBeing) {
        optionsRepo.save(new Animal(
                "Troll",
                3.0,
                7.0,
                3,
                0.0,
                0.0,
                false,
                false,
                magicalBeing,
                "A troll is a magical beast of prodigious strength and immense stupidity. " +
                        "In fact, they are so synonymous with stupidity that they actually " +
                        "had a wizarding exam failing grade named after them."
        ));
    }

    // Weitere Tiere
    // Acrumantula für Deatheater

    // möglicherweise noch Wasserwesen, die nur an Wasserorten genutzt werden können
    // Grindelow
    // Hippocampus
    // Kappa
    // Kelpie
    // Merpeople
    // Sea serpent
    // Selma
    // 


}
