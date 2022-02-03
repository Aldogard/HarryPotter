package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PotionService {

    private OptionsRepo optionsRepo;

    //Potions
    public void createAntiParalysis(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Anti-Paralysis",
                storage,
                0.0,
                0.0,
                true,
                false,
                false,
                false,
                0.0,
                1.0,
                false,
                false,
                false,
                0,
                magicalBeing,
                "A potion that heals paralysis."));
    }


    public void createBrainElixir(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Baruffios Brain Elixir",
                storage,
                0.0,
                0.0,
                false,
                false,
                false,
                false,
                0.0,
                1.5,
                false,
                false,
                false,
                5,
                magicalBeing,
                "A potion that apparently increases the taker's brain power."));
    }

    public void createExplodingPotion(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Exploding Potion",
                storage,
                0.0,
                0.0,
                false,
                false,
                false,
                false,
                10.0,
                1.0,
                false,
                false,
                false,
                5,
                magicalBeing,
                "A very volatile potion, and when completed, can be used to create explosions."));
    }

    public void createHealingPotion(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Healing Potion",
                storage,
                0.35,
                0.1,
                false,
                false,
                false,
                false,
                0.0,
                1.0,
                false,
                false,
                false,
                0,
                magicalBeing,
                "This potion was extremely useful when duelling Dark MagicalBeings or dark creatures " +
                        "in Fortresses, making it an essential supply for all Aurors."));
    }

    public void createInvogiration(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Invigoration Draught",
                storage,
                0.0,
                0.8,
                false,
                false,
                false,
                false,
                0.0,
                1.0,
                false,
                false,
                false,
                0,
                magicalBeing,
                "A potion that is presumed to give the taker an energy boost."));
    }

    public void createUnicornBlood(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Unicorn Blood",
                storage,
                -0.5,
                0.0,
                false,
                false,
                false,
                true,
                0.0,
                1.0,
                false,
                false,
                false,
                10,
                magicalBeing,
                "The blood of a unicorn could be drunk in order to keep a person alive. " +
                        "However, the act of slaying a unicorn would cause the drinker to suffer a cursed life."

        ));
    }

    public void createRegenerationPotion(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save((new Potion(
                "Regeneration Potion",
                storage,
                -0.5,
                0.0,
                false,
                false,
                true,
                false,
                0.0,
                1.0,
                false,
                false,
                false,
                15,
                magicalBeing,
                "Helps restore non-corporeal magicalBeings to their bodies. " +
                        "Can only be used by Deatheaters to bring Voldemort back to life."
        )));
    }

    public void createWitSharpeningPotion(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Wit-Sharpening Potion",
                storage,
                0.0,
                0.0,
                false,
                true,
                false,
                false,
                0.0,
                1.0,
                false,
                false,
                false,
                3,
                magicalBeing,
                "Presumably enhances the clarity of thought of the drinker."
        ));
    }

    public void createExtimuloPotion(MagicalBeing magicalBeing, Integer storage) {
        optionsRepo.save(new Potion(
                "Extimulo Potion",
                storage,
                0.0,
                0.0,
                false,
                false,
                false,
                false,
                0.0,
                1.25,
                false,
                false,
                false,
                0,
                magicalBeing,
                "Boosts the spell power of the drinker."));
    }

}
