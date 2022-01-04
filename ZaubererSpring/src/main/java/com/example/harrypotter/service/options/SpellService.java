package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpellService {

    private OptionsRepo optionsRepo;

    //Attacks
    public void createExpelliarmus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Expelliarmus",
                5.0,
                10.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                wizard,
                "Forces whatever an opponent is holding to fly out of their hand. " +
                        "It was considered to be Harry Potter's signature spell."));
    }

    public void createStupefy(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Stupefy",
                7.0,
                2.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                5,
                wizard,
                "Stuns the target, rendering them unconscious."
        ));
    }

    public void createLevicorpus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Levicorpus",
                3.5,
                5.0,
                0.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                0,
                wizard,
                "Hoists people up into the air by their ankle. Created by Severus Snape."));
    }

    public void createCalvorio(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Calvorio",
                1.0,
                3.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                wizard,
                "Removes the victim's hair."));
    }

    public void createImmobilus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Immobilus",
                3.0,
                0.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                wizard,
                "Immobilises and stops the actions of the target. " +
                        "It works both on living and inanimate things."));
    }

    public void createSectumssempra(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Sectumssempra",
                10.0,
                17.5,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                10,
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
                0.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                3,
                wizard,
                "Causes the victim to become confused and befuddled."));
    }

    public void createAvadaKedavra(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Avada Kedavra",
                25.0,
                40.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                25,
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
                0.0,
                false,
                true,
                true,
                false,
                false,
                false,
                false,
                15,
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
                0.0,
                false,
                true,
                false,
                true,
                false,
                false,
                false,
                20,
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
                0.0,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                5,
                wizard,
                "Invisible shield that reflects spells and blocks physical entities."));
    }

    public void createFiendfyre(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Fiendfyre",
                20.0,
                50.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                true,
                false,
                20,
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
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                true,
                25,
                wizard,
                "Only possibility to end the Fiendfyre. " +
                        "If not used immediately after casting the Fiendfyre, the casting wizard will be killed by it."));
    }

    public void createFirestorm(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Firestorm",
                15.0,
                27.5,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                wizard,
                "Produces a ring of fire from the wand."
        ));
    }

    public void createPiertotumLocomotor(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Piertotum Locomotor",
                10.0,
                20.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                wizard,
                "Brings animates inanimate targets"
        ));
    }

    public void createVulneraSanentur(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Vulnera Sanentur",
                15.0,
                0.0,
                0.8,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                wizard,
                "Healing spell that slows blood flow, clears residue, and knits wounds. It is the counter-curse to Sectumsempra."

        ));
    }

    public void createPertrificusTotalus(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Pertrificus Totalus",
                5.0,
                1.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                1,
                wizard,
                "Used to temporarily bind the victim's body in a position much like that of a soldier at attention; the victim will usually fall to the ground."
        ));
    }

    public void createEpiskey(Wizard wizard) {
        optionsRepo.save(new Spell(
                "Episkey",
                5.0,
                0.0,
                0.1,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                1,
                wizard,
                "In 1996, Nymphadora Tonks used this spell to fix Harry's broken nose after Draco Malfoy broke it on the Hogwarts Express."

        ));
    }
}
