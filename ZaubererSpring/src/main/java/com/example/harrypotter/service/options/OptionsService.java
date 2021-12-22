package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class OptionsService {

    private OptionsRepo optionsRepo;

    //Attacks
    public void createExpelliarmus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Expelliarmus",
                5.0,
                10.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Forces whatever an opponent is holding to fly out of their hand. " +
                        "It was considered to be Harry Potter's signature spell."));
    }

    public void createStupefy(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Stupefy",
                5.0,
                1.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Stuns the target, rendering them unconscious."
        ));
    }

    public void createLevicorpus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Levicorpus",
                3.5,
                5.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Hoists people up into the air by their ankle. Created by Severus Snape."));
    }

    public void createCalvorio(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Calvorio",
                1.0,
                3.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Removes the victim's hair."));
    }

    public void createImmobilus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Immobilus",
                3.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Immobilises and stops the actions of the target. " +
                        "It works both on living and inanimate things."));
    }

    public void createSectumssempra(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Sectumssempra",
                10.0,
                17.5,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Lacerates the target, as if they have been \"slashed by a sword.\" " +
                        "Subsequently, the target can easily bleed to death from the wounds. " +
                        "This curse was invented by Severus Snape, to be used against his personal enemies."));
    }

    public void createConfundo(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Confundo",
                2.5,
                1.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Causes the victim to become confused and befuddled."));
    }

    public void createAvadaKedavra(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Avada Kedavra",
                25.0,
                40.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Causes instantaneous death. It is accompanied by a flash of green light and a rushing noise. " +
                        "There is no known Counter-curse that can protect the victim from dying, " +
                        "except for a loving sacrifice. It is one of the three Unforgivable Curses."));
    }

    public void createImperio(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Imperio",
                15.0,
                5.0,
                false,
                true,
                true,
                false,
                false,
                false,
                false,
                wizard,
                "Places the victim completely under the caster's control and it " +
                        "becomes very suggestible to the commands of the caster. " +
                        "However, those who are strong willed may learn to resist it. " +
                        "One of the three Unforgivable Curses."));
    }

    public void createCrucio(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Crucio",
                15.0,
                25.0,
                false,
                true,
                false,
                true,
                false,
                false,
                false,
                wizard,
                "Inflicts intense pain on the recipient of the curse. " +
                        "It cannot be cast successfully by a person who is doing so out of pure spite or anger; " +
                        "one must feel a true desire to cause the victim pain."));
    }

    public void createProtego(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Protego",
                10.0,
                0.0,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                wizard,
                "Invisible shield that reflects spells and blocks physical entities."));
    }

    public void createFiendfyre(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Fiendfyre",
                20.0,
                50.0,
                false,
                false,
                false,
                false,
                false,
                true,
                false,
                wizard,
                "Unleashes cursed fire that actively seek out " +
                        "living targets and burn anything in its path. " +
                        "In addition, this fire is made even more dangerous due to the fact " +
                        "that it is extremely difficult to control."));
    }

    public void createAntiFiendfyre(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Anti Fiendfyre",
                10.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                true,
                wizard,
                "Only possibility to end the Fiendfyre. " +
                        "If not used immediately after casting the Fiendfyre, the casting wizard will be killed by it."));
    }

    public void createFirestorm(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Firestorm",
                15.0,
                27.5,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Produces a ring of fire from the wand."
        ));
    }

    public void createPiertotumLocomotor(Wizard wizard){
        optionsRepo.save(new Spell(
                "Piertotum Locomotor",
                10.0,
                20.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                wizard,
                "Brings animates inanimate targets"
        ));
    }







    // Refilling Charm --> Kann einen Trank wiederherstellen
    // Vulnera Sanentur --> Macht (einen Teil von) Sectrumssempra Effekt rückgängig
    // Pertrificus Totalus


    //Potions
    public void createAntiParalysis(Wizard wizard, Integer storage) {
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
                wizard,
                "A potion that heals paralysis."));
    }


    public void createBrainElixir(Wizard wizard, Integer storage) {
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
                wizard,
                "A potion that apparently increases the taker's brain power."));
    }

    public void createExplodingPotion(Wizard wizard, Integer storage) {
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
                wizard,
                "A very volatile potion, and when completed, can be used to create explosions."));
    }

    public void createHealingPotion(Wizard wizard, Integer storage) {
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
                wizard,
                "This potion was extremely useful when duelling Dark Wizards or dark creatures " +
                        "in Fortresses, making it an essential supply for all Aurors."));
    }

    public void createInvogiration(Wizard wizard, Integer storage) {
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
                wizard,
                "A potion that is presumed to give the taker an energy boost."));
    }

    public void createUnicornBlood(Wizard wizard, Integer storage) {
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
                wizard,
                "The blood of a unicorn could be drunk in order to keep a person alive. " +
                        "However, the act of slaying a unicorn would cause the drinker to suffer a cursed life."

        ));
    }

    public void createRegenerationPotion(Wizard wizard, Integer storage) {
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
                wizard,
                "Helps restore non-corporeal wizards to their bodies. " +
                        "Can only be used by Deatheaters to bring Voldemort back to life."
        )));
    }

    public void createWitSharpeningPotion(Wizard wizard, Integer storage) {
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
                wizard,
                "Presumably enhances the clarity of thought of the drinker."
        ));
    }

    public void createExtimuloPotion(Wizard wizard, Integer storage) {
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
                wizard,
                "Boosts the spell power of the drinker."));
    }

}
